package com.example.miwok.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miwok.R
import com.example.miwok.databinding.ItemFragmentBinding
import com.example.miwok.viewmodel.WordViewModel
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

    private var _binding: ItemFragmentBinding? = null
    private val binding get() = _binding!!

    // ViewModel instance
    private val viewModel: WordViewModel by viewModels()  //koristen viewmodel ovdje laganiiiiiii
    private lateinit var adapter: WordAdapter // Adapter za prikaz podataka

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ItemFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WordAdapter(mutableListOf(),viewModel) //ovdje incijaliziram adapter sa view modelom kako bih mogao upravljati repordukcijom zvuka
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        RecyclerViewDivider.addDivider(binding.recyclerView, requireContext())

        val category = arguments?.getString(ARG_CATEGORY) ?: "numbers"
        viewModel.loadWords(category)  // Pozivanje učitavanja podataka prema kategoriji

        lifecycleScope.launch {
            when (category) {
                "numbers" -> viewModel.numbers.collect { adapter.updateList(it) }
                "family" -> viewModel.family.collect { adapter.updateList(it) }
                "colors" -> viewModel.colors.collect { adapter.updateList(it) }
                "phrases" -> viewModel.phrases.collect { adapter.updateList(it) }
            }
        }

        // Postavljanje boje pozadine na osnovu kategorije
        val backgroundColor = when (category) {
            "numbers" -> R.color.category_numbers
            "family" -> R.color.category_family
            "colors" -> R.color.category_colors
            "phrases" -> R.color.category_phrases
            else -> R.color.category_numbers
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
}
