package com.example.miwok.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter

object RecyclerViewDivider {
    fun addDivider(recyclerView: RecyclerView, context: Context, colorHex: String = "#A8A19E", height: Int = 3) {
        val color = colorHex.toColorInt()

        val dividerDrawable = ShapeDrawable(RectShape()).apply {
            intrinsicHeight = height
            paint.color = color
            paint.style = Paint.Style.FILL
        }

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
            setDrawable(dividerDrawable)
        }

        recyclerView.addItemDecoration(divider)
    }
}