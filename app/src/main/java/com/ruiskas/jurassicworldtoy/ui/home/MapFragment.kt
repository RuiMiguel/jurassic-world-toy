package com.ruiskas.jurassicworldtoy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ruiskas.jurassicworldtoy.R
import com.ruiskas.jurassicworldtoy.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding

    val SYDNEY = LatLng(-33.862, 151.21)
    val ZOOM_LEVEL = 13f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        initMap()
    }

    private fun initMap() {
        (childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)?.getMapAsync { map ->
            with(map) {
                moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, ZOOM_LEVEL))
                addMarker(MarkerOptions().position(SYDNEY))
            }
        }

    }
}
