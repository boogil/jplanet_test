package com.gilly.jplanettest.presentation.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * @param horiPadding px 단위
 */
class CustomDecoration(val horiPadding: Int, val vertPadding: Int, val spanCount: Int = 0) : RecyclerView.ItemDecoration() {
    var topExceptionPositions = arrayListOf<Int>()
    var bottomExceptionPositions = arrayListOf<Int>()
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val remainder = position % spanCount

        outRect.right = horiPadding / 2
        outRect.left = horiPadding / 2
        outRect.top = vertPadding / 2
        outRect.bottom = vertPadding / 2
    }
}