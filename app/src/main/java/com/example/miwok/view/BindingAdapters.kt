package com.example.miwok.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageOrGone")
fun bindImageOrGone(view: ImageView, resId: Int?) {
    if (resId != null) {
        view.setImageResource(resId)
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
