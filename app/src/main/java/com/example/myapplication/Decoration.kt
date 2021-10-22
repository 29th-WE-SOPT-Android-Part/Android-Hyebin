package com.example.myapplication

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class Decoration (val right: Int, val left: Int, val height: Int, val color: Int):
    RecyclerView.ItemDecoration() {
    private val paint = Paint()
    init {
        paint.color = color
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = right
        outRect.left = left
        outRect.top = height
        outRect.bottom = height
    }

}

