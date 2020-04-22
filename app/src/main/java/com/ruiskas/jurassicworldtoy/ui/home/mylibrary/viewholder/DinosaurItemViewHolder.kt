package com.ruiskas.jurassicworldtoy.ui.home.mylibrary.viewholder

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder
import com.ruiskas.jurassicworldtoy.R
import com.ruiskas.jurassicworldtoy.domain.model.DinosaurItem

class DinosaurItemViewHolder(
    private val context: Context,
    parent: ViewGroup
) : BaseViewHolder<DinosaurItem>(context, parent, R.layout.item_dinosaur) {

    private val icon = itemView.findViewById<ImageView>(R.id.dinosaur_image)
    private val name = itemView.findViewById<TextView>(R.id.dinosaur_name)

    override fun bindTo(value: DinosaurItem, position: Int) {
        transitionNames(value)

        //icon.setImageResource(value.image)
        name.text = value.name.capitalize()
    }

    private fun transitionNames(value: DinosaurItem) {
        icon.transitionName = context.getString(R.string.transition_item_dinosaur_icon).format(value.id)
        name.transitionName = context.getString(R.string.transition_item_dinosaur_text).format(value.id)
    }
}