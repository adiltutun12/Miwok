package com.example.miwok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miwok.databinding.ItemWordBinding

class WordAdapter(private val words: MutableList<Word>) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null

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
            playAudio(holder.binding.root.context, word.audioResourceId)
        }
    }

    fun updateList(newWords: List<Word>) {
        words.clear()
        words.addAll(newWords)    //dinamicko osvjezavanje liseze
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = words.size

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun playAudio(context: Context, audioResId: Int) {
        releaseMediaPlayer()
        mediaPlayer = MediaPlayer.create(context, audioResId)
        mediaPlayer?.start()
        mediaPlayer?.setOnCompletionListener {
            releaseMediaPlayer()
        }
    }
}
