package com.example.miwok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val words: List<Word>) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
        //sada ću ovdje dodati media player prvo dodajem varijablu
        //MediaPlayer je varijabla koja sluzi za pustanje zvuka
        private var mediaPlayer : MediaPlayer? = null

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) { //definisanje elementa u svakom redu liste
        val miwokText: TextView = view.findViewById(R.id.text)
        val defaultText: TextView = view.findViewById(R.id.text2)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        //val buttonPlay: ImageView = view.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false) //ucita item_word u memoriju, ova metoda je kreiranje novoh Viewa
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.miwokText.text = word.miwokTranslation //postavljam ovdje miwok jezik
        holder.defaultText.text = word.defaultTranslation //ovdje postavljam eng prijevodd

        //Ako postoji slika p0ostavi je, inače sakrij jer u ovom phrases nema tako da sakrij je ImageView
        if (word.imageResourceId != null) {
            holder.imageView.setImageResource(word.imageResourceId)
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.imageView.visibility = View.GONE
        }

        //dodajem sada klik za cijeli item
        holder.itemView.setOnClickListener {
            playAudio(holder.itemView.context, word.audioResourceId) //kada se klikne na dugme omogućeno da se počne zvuk izvrsavati
        }

    }

    private fun playAudio(context: Context, audioResourceId: Int) {
        //ako postoji aktivan MediaPlayer, zaustavi ga i oslobodi resurse
        releaseMediaPlayer()

        mediaPlayer = MediaPlayer.create(context, audioResourceId)
        mediaPlayer?.start()

        //kada se zvuk završi, moram osloboditi MediaPlayer
        mediaPlayer?.setOnCompletionListener {
            releaseMediaPlayer()
        }
    }


    fun releaseMediaPlayer() { //dodana metoda za zaustavljanje i oslobadjanje resursa imam ovdje dupilicranje kasnije cu popraviti
        mediaPlayer?.release()
        mediaPlayer = null
    }
    override fun getItemCount(): Int = words.size
}

