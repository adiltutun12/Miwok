package com.example.miwok

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miwok.databinding.ItemFragmentBinding
import kotlinx.coroutines.launch

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

    //private lateinit var wordList: List<Word>
    //private var backgroundColorRes: Int = R.color.category_numbers
    private var _binding: ItemFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: WordAdapter //dodan adapter vezano za ovu bazu podataka

    /* override fun onCreate(savedInstanceState: Bundle?) {
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
    */


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ItemFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColorRes))
        adapter= WordAdapter(mutableListOf())
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        //binding.recyclerView.adapter = WordAdapter(wordList)
        RecyclerViewDivider.addDivider(binding.recyclerView, requireContext())

        val category = arguments?.getString(ARG_CATEGORY)?: "numbers"
        Log.e("TCHIAO", "onViewCreated: ${MiwokDatabase.getDatabase(requireContext())}", )
        val dao= MiwokDatabase.getDatabase(requireContext()).wordDao()

        //postavljanje pozadine
        val backgroundColor = when (category) {
            "numbers" -> R.color.category_numbers
            "family" -> R.color.category_family
            "colors" -> R.color.category_colors
            "phrases" -> R.color.category_phrases
            else -> R.color.category_numbers
        }
        binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColor))

        lifecycleScope.launch {
            when (category) {
                "numbers" -> dao.getNumbers().collect {
                    adapter.updateList(it.toWordListNumbers())
                }
                "family" -> dao.getFamily().collect {
                    adapter.updateList(it.toWordListFamily())
                }
                "colors" -> dao.getColors().collect {
                    adapter.updateList(it.toWordListColors())
                }
                "phrases" -> dao.getPhrases().collect {
                    adapter.updateList(it.toWordListPhrases())
                }
            }
        }

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
