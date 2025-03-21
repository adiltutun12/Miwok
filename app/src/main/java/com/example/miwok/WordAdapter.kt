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
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() { //lista wordova da bude prikazana u recycler viewu, povezuje podatke sa recyclerviewom
        //WordViewHolder optimizuje podatke da ih ne moramo svaki put prikazivati
        //sada ću ovdje dodati media player prvo dodajem varijablu
        //MediaPlayer je varijabla koja sluzi za pustanje zvuka
        private var mediaPlayer : MediaPlayer? = null

    //optimizovan prikaz da nne moramo svaki put ponovno kreirati view

    //drzi refernece na ui elementata jednog reda
    //kada ovo uradimo ne moramo svaki put pozivati da pronadje id elementa kada skrolamo
    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) { //definisanje elementa u svakom redu liste
        val miwokText: TextView = view.findViewById(R.id.text)
        val defaultText: TextView = view.findViewById(R.id.text2)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder { //pravi novi red u listi
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false) //ucita item_word u memoriju, ova metoda je kreiranje novoh Viewa
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) { //postavlja tacne vrijednosti u UI elemente fakticki popunjava ispravnim podacima
        val word = words[position]
        holder.miwokText.text = word.miwokTranslation //postavljam ovdje miwok jezik
        holder.defaultText.text = word.defaultTranslation //ovdje postavljam eng prijevodd

        //Ako postoji slika p0ostavi je, inače sakrij jer u ovom phrases nema tako da sakrij je
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


    fun releaseMediaPlayer() { //dodana metoda za zaustavljanje i oslobadjanje resursa, sprjecava i viseklikabnost da se pokrece vise puta te se mijesa zvuk
        mediaPlayer?.release()
        mediaPlayer = null
    }
    override fun getItemCount(): Int = words.size
}

