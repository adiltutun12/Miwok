package com.example.miwok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentNumbers : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_numbers)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val words = listOf(
            Word("lutti", "one", R.drawable.number_one, R.raw.number_one),
            Word("otiiko", "two", R.drawable.number_two,  R.raw.number_two),
            Word("tolookosu", "three", R.drawable.number_three,  R.raw.number_three),
            Word("oyyisa", "four", R.drawable.number_four,  R.raw.number_four),
            Word("massokka", "five", R.drawable.number_five,  R.raw.number_five),
            Word("temmokka", "six", R.drawable.number_six,  R.raw.number_six),
            Word("kenekaku", "seven", R.drawable.number_seven,  R.raw.number_seven),
            Word("kawinta", "eight", R.drawable.number_eight,  R.raw.number_eight),
            Word("wo'e", "nine", R.drawable.number_nine,  R.raw.number_nine),
            Word("na'aacha", "ten", R.drawable.number_ten,  R.raw.number_ten)

            )

        val adapter = WordAdapter(words)
        recyclerView.adapter = adapter
    }
}
