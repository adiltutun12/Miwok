package com.example.miwok

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


object RecyclerViewDivider {
    fun addDivider(recyclerView: RecyclerView, context: Context, colorHex: String = "#A8A19E", height: Int = 3) {
        val color = Color.parseColor(colorHex) //parsiranje HEX string u int boju

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
//ovo sam bio zeznuo radi teme uredjaja zbog toga se zeznulo ovo , zato cu sada korisitiii defaultni divider bio sam stavio pogrešnu temu i to me zeznulo
