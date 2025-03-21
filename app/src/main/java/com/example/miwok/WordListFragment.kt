package com.example.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordListFragment : Fragment() {

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): WordListFragment {
            val fragment = WordListFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var wordList: List<Word>
    private var backgroundColorRes: Int = R.color.category_numbers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (arguments?.getString(ARG_CATEGORY)) {
            "numbers" -> {
                wordList = WordData.numbers
                backgroundColorRes = R.color.category_numbers
            }
            "family" -> {
                wordList = WordData.family
                backgroundColorRes = R.color.category_family
            }
            "colors" -> {
                wordList = WordData.colors
                backgroundColorRes = R.color.category_colors
            }
            "phrases" -> {
                wordList = WordData.phrases
                backgroundColorRes = R.color.category_phrases
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColorRes))

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = WordAdapter(wordList)

        RecyclerViewDivider.addDivider(recyclerView, requireContext()) //pozvana jer sam joj vec unaprijed stavio parametre
    }

    override fun onPause() {
        super.onPause()
        (view?.findViewById<RecyclerView>(R.id.recycler_view)?.adapter as? WordAdapter)?.releaseMediaPlayer()
    }
}
