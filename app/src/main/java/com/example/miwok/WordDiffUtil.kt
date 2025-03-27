package com.example.miwok


import androidx.recyclerview.widget.DiffUtil
import com.example.miwok.model.Word

class WordDiffUtil(
    private val oldList: List<Word>,
    private val newList: List<Word>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Uporedi ID-eve ili neki drugi jedinstveni atribut svakog objekta
        return oldList[oldItemPosition].defaultTranslation == newList[newItemPosition].defaultTranslation
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Uporedi sve relevantne atribute objekta
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}


/*

@SuppressLint("NotifyDataSetChanged")
fun updateList(newWords: List<Word>) {
    val diffCallback = WordDiffCallback(words, newWords)
    val diffResult = DiffUtil.calculateDiff(diffCallback)

    words.clear()
    words.addAll(newWords)
    diffResult.dispatchUpdatesTo(this)  // Ovdje se koristi adapter (this)
}


 */