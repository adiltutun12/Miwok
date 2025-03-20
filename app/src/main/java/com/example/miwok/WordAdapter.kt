package com.example.miwok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val words: List<Word>) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
        //sada ću ovdje dodati media player prvo dodajem varijablu
        private var mediaPlayer : MediaPlayer? = null

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val miwokText: TextView = view.findViewById(R.id.text)
        val defaultText: TextView = view.findViewById(R.id.text2)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val buttonPlay: ImageButton = view.findViewById(R.id.buttonPlay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    /*
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.miwokText.text = word.miwokTranslation
        holder.defaultText.text = word.defaultTranslation
        holder.imageView.setImageResource(word.imageResourceId)

        holder.buttonPlay.setOnClickListener {
            //Kasnije ide dodavnje logike za dugme play i prosiravnje tako da radi i zvuk ovaj
        }
    }
    */
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.miwokText.text = word.miwokTranslation
        holder.defaultText.text = word.defaultTranslation

        //Ako postoji slika p0ostavi je, inače sakrij jer u ovom phrases nema tako da sakrij je
        //ImageView
        if (word.imageResourceId != null) {
            holder.imageView.setImageResource(word.imageResourceId)
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.imageView.visibility = View.GONE
        }

        holder.buttonPlay.setOnClickListener {
            //logikaa ovdjee aaa
            playAudio(holder.itemView.context, word.audioResourceId)
        }
    }

    private fun playAudio(context: Context, audioResourceId: Int){
        //ako postoji aktivan mediaplayer zaustavi ga
        mediaPlayer?.release()
        mediaPlayer=MediaPlayer.create(context,audioResourceId)
        mediaPlayer?.start()

        //kada zvuk bude gotov onda potrebno osloboditi resurse
        mediaPlayer?.setOnCompletionListener {
            mediaPlayer?.release()
            mediaPlayer=null
        }
    }

    override fun getItemCount(): Int = words.size
}

