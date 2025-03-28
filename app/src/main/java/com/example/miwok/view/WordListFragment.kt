package com.example.miwok.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miwok.model.Category
import com.example.miwok.R
import com.example.miwok.WordAdapterListener
import com.example.miwok.databinding.ItemFragmentBinding
import com.example.miwok.model.Word
import com.example.miwok.viewmodel.WordViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WordListFragment : Fragment(), WordAdapterListener {

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: Category): WordListFragment {
            val fragment = WordListFragment()
            fragment.arguments = Bundle().apply {
                putSerializable(ARG_CATEGORY, category.name)
            }
            return fragment
        }
    }

    private var _binding: ItemFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WordViewModel by activityViewModels()
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ItemFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WordAdapter(mutableListOf(), this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        RecyclerViewDivider.addDivider(binding.recyclerView, requireContext())

        val categoryName = arguments?.getString(ARG_CATEGORY)
        val category = categoryName?.let { Category.valueOf(it) } ?: Category.NUMBERS
        viewModel.loadWords(category)


       lifecycleScope.launch {
            when (category) {
                Category.NUMBERS -> viewModel.numbers.collectLatest { adapter.updateList(it) }
                Category.FAMILY -> viewModel.family.collectLatest { adapter.updateList(it) }
                Category.COLORS -> viewModel.colors.collectLatest { adapter.updateList(it) }
                Category.PHRASES -> viewModel.phrases.collectLatest { adapter.updateList(it) }
            }
        }


        val backgroundColor = when (category) {
            Category.NUMBERS -> R.color.category_numbers
            Category.FAMILY -> R.color.category_family
            Category.COLORS -> R.color.category_colors
            Category.PHRASES -> R.color.category_phrases
        }
        binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColor))
    }

    override fun onPause() {
        super.onPause()
        viewModel.releaseMediaPlayer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onWordClick(word: Word) {
        viewModel.playAudio(word.audioResourceId)
    }
}
