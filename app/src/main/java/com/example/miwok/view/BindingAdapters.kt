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
/* ovdje sam koristio ovo @BindnigAdapter("imagerGone") jer onda u xml-u android prepoznaje da atribut
 app:imageOrGone treba da pozove ovu metodu jer android src ne moze upravljati null vrijednostima te zbpg toga */