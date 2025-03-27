package com.example.miwok.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.miwok.WordAdapterListener
import com.example.miwok.WordDiffUtil
import com.example.miwok.databinding.ItemWordBinding
import com.example.miwok.model.Word
import com.example.miwok.viewmodel.WordViewModel

class WordAdapter(private val words: MutableList<Word>,
                  private val listener: WordAdapterListener) :

    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWordBinding.inflate(inflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.binding.word = word

        holder.binding.root.setOnClickListener {
            listener.onWordClick(word)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newWords: List<Word>) {
        val diffCallback = WordDiffUtil(words, newWords)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        words.clear()
        words.addAll(newWords)//dinamicko osvjezavanje liseze
        diffResult.dispatchUpdatesTo(this)  // Ovdje se koristi adapter (this)
    }


    override fun getItemCount(): Int = words.size

}
