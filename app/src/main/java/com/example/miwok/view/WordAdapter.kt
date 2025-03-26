package com.example.miwok.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miwok.databinding.ItemWordBinding
import com.example.miwok.model.Word
import com.example.miwok.viewmodel.WordViewModel

//ovdje kao konstruktor sam proslijedio i ovaj wordview
class WordAdapter(private val words: MutableList<Word>, private val wordview : WordViewModel) :

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
            wordview.playAudio(word.audioResourceId)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newWords: List<Word>) {
        words.clear()
        words.addAll(newWords)    //dinamicko osvjezavanje liseze
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = words.size

}
