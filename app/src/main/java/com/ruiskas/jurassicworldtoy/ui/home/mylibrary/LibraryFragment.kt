package com.ruiskas.jurassicworldtoy.ui.home.mylibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gigigo.baserecycleradapter.adapter.BaseRecyclerAdapter
import com.ruiskas.jurassicworldtoy.databinding.FragmentLibraryBinding
import com.ruiskas.jurassicworldtoy.domain.model.DinosaurItem
import com.ruiskas.jurassicworldtoy.ui.home.decoration.PaddingOffsetDecoration
import com.ruiskas.jurassicworldtoy.ui.home.mylibrary.viewholder.DinosaurItemViewHolder
import kotlinx.android.synthetic.main.item_dinosaur.view.*

class LibraryFragment : Fragment() {
    private lateinit var binding: FragmentLibraryBinding

    private var libraryAdapter: BaseRecyclerAdapter<DinosaurItem>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() {
        initRecycler()
    }

    private fun initRecycler() {
        activity?.let { fragmentActivity ->
            libraryAdapter = BaseRecyclerAdapter(fragmentActivity.applicationContext)
            libraryAdapter?.apply {
                bind<DinosaurItem, DinosaurItemViewHolder>()
                setItemClickListener { position, view ->
                    getItem(position)?.let { item ->
                        val image = view.dinosaur_image
                        val name = view.dinosaur_name

                        val extras = FragmentNavigatorExtras(
                            image to image.transitionName,
                            name to name.transitionName
                        )

                        /*
                            findNavController().navigate(
                                HomeFragmentDirections.actionScreenHomeToScreenHeating(),
                                extras
                            )
                        }*/
                    }
                }
            }

            with(binding.myLibraryRecycler) {
                layoutManager = GridLayoutManager(fragmentActivity, 4, RecyclerView.VERTICAL, false)
                addItemDecoration(PaddingOffsetDecoration(resources, 0, 10, 10))
                adapter = libraryAdapter
            }
        }
    }

    private fun initViewModel() {
        libraryAdapter?.append(
            MutableList(100) {
                DinosaurItem(
                    id = "$it",
                    image = "",
                    name = "name$it"
                )
            }
        )
    }
}
