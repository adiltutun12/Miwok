package com.example.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miwok.databinding.ItemFragmentBinding

class WordListFragment : Fragment() {

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): WordListFragment {
            val fragment = WordListFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
            return fragment
        }
    }

    private lateinit var wordList: List<Word>
    private var backgroundColorRes: Int = R.color.category_numbers
    private var _binding: ItemFragmentBinding? = null
    private val binding get() = _binding!!

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
            else -> {
                wordList = emptyList()
                backgroundColorRes = R.color.category_numbers
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ItemFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColorRes))
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = WordAdapter(wordList)
        RecyclerViewDivider.addDivider(binding.recyclerView, requireContext())
    }

    override fun onPause() {
        super.onPause()
        (binding.recyclerView.adapter as? WordAdapter)?.releaseMediaPlayer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
