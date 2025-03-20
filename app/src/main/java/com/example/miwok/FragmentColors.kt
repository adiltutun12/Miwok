package com.example.miwok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentColors : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_colors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_colors)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val words = listOf(
            Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red),
            Word("chiwiiṭə", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow),
            Word("ṭopiisə", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
            Word("chokokki", "green", R.drawable.color_green, R.raw.color_green),
            Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown),
            Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray),
            Word("kululli", "black", R.drawable.color_black, R.raw.color_black),
            Word("kelelli", "white", R.drawable.color_white, R.raw.color_white)

            )

        val adapter = WordAdapter(words)
        recyclerView.adapter = adapter
    }
}
