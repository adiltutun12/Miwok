package com.example.miwok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentPhrases : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_phrases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_phrases)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val words = listOf(
            Word("minto wuksus?", "Where are you going?", null, R.raw.phrase_where_are_you_going),
            Word("tinna oyaase'na", "What is your name?",null, R.raw.phrase_what_is_your_name),
            Word("oyaaset...", "My name is...", null, R.raw.phrase_my_name_is),
            Word("michakses?", "How are you feeling?", null, R.raw.phrase_how_are_you_feeling),
            Word("kuchi achit", "I'm feeling good.", null, R.raw.phrase_im_feeling_good),
            Word("aanas'aa?", "Are you coming?", null, R.raw.phrase_are_you_coming),
            Word("hee'eenem", "Yes, I'm coming.", null, R.raw.phrase_im_coming),
            Word("eenem", "I'm coming.", null, R.raw.phrase_yes_im_coming),
            Word("yoowutis", "Let's go.", null, R.raw.phrase_lets_go),
            Word("enni'nem", "Come here.", null, R.raw.phrase_come_here)

            )

        val adapter = WordAdapter(words)
        recyclerView.adapter = adapter
    }
}
