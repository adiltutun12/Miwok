package com.example.miwok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentFamily : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_family, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_family)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val words = listOf(
            Word("əpə", "father", R.drawable.family_father, R.raw.family_father),
            Word("əṭa", "mother", R.drawable.family_mother, R.raw.family_mother),
            Word("angsi", "son", R.drawable.family_son, R.raw.family_son),
            Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter),
            Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother),
            Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother),
            Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister),
            Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister),
            Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother),
            Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather)

            )

        val adapter = WordAdapter(words)
        recyclerView.adapter = adapter
    }
}
