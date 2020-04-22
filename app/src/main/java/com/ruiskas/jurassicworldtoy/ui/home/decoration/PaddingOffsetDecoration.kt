package com.ruiskas.jurassicworldtoy.ui.home.decoration

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.annotation.Dimension
import androidx.annotation.Px
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruiskas.jurassicworldtoy.ui.base.extensions.MetricUtils.dpToPx

open class PaddingOffsetDecoration(
    @Px private val start: Int = 0,
    @Px private val internal: Int = 0,
    @Px private val end: Int = 0
) :
    RecyclerView.ItemDecoration() {

    private enum class LayoutType { LINEAR, GRID, DEFAULT }
    private enum class OrientationType { VERTICAL, HORIZONTAL, DEFAULT }

    private var layout: LayoutType =
        LayoutType.DEFAULT
    private var orientation: OrientationType =
        OrientationType.DEFAULT

    constructor(
        resources: Resources,
        @Dimension(unit = Dimension.DP) startDip: Int = 0,
        @Dimension(unit = Dimension.DP) internalDip: Int = 0,
        @Dimension(unit = Dimension.DP) endDip: Int = 0
    ) : this(
        dpToPx(resources, startDip),
        dpToPx(resources, internalDip),
        dpToPx(resources, endDip)
    )

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemCount = state.itemCount
        val currentPosition = parent.getChildAdapterPosition(view)

        with(parent.layoutManager) {
            when (this) {
                is LinearLayoutManager -> {
                    layout = LayoutType.LINEAR
                    when (orientation) {
                        RecyclerView.VERTICAL -> this@PaddingOffsetDecoration.orientation =
                            OrientationType.VERTICAL
                        RecyclerView.HORIZONTAL -> this@PaddingOffsetDecoration.orientation =
                            OrientationType.HORIZONTAL
                    }
                }
                is GridLayoutManager -> layout = LayoutType.GRID
            }
        }

        val start = startOffset(currentPosition)
        val end = endOffset(currentPosition, itemCount)

        drawRect(start, end, outRect)
    }

    private fun startOffset(currentPosition: Int): Int {
        return if (currentPosition == 0) {
            start
        } else {
            0
        }
    }

    private fun endOffset(currentPosition: Int, itemCount: Int): Int {
        return if (itemCount > 0 && currentPosition == itemCount - 1) {
            end
        } else {
            internal
        }
    }

    private fun drawRect(start: Int, end: Int, outRect: Rect) {
        when (layout) {
            LayoutType.LINEAR -> {
                when (orientation) {
                    OrientationType.VERTICAL -> {
                        outRect.set(0, start, 0, end)
                    }
                    OrientationType.HORIZONTAL -> {
                        outRect.set(start, 0, end, 0)
                    }
                }
            }
            LayoutType.GRID -> {
                //outRect.set(start, start, end, end)
            }
        }
    }
}