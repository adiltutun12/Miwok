package com.example.miwok.viewmodel

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.miwok.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//class WordViewModel(application: Application) : AndroidViewModel(application) {
    // private val database = MiwokDatabase.getDatabase(application)
    // private val wordDao = database.wordDao()

@HiltViewModel //ova anotacija oznacava da hilt upravlja ovim viewmodeom i dozvoljava injectovanje zavisnosti direktno u konstruktor
class WordViewModel @Inject constructor( //ovo omogucava da se automatski pruzaju potrebne zavisnosti
    application: Application,
    private val wordDao: WordDao // Injectovano direktno ovdje ovo preko hilta, ovo radimo umjesto da stvaramo instanci MIwokDatabase i izvlačimo WOrdDao sada ga injectujemo direktno, olakšava testiranje i upravljanje kodom zakomentarisno je kako je bez injecta ovo
    ) : AndroidViewModel(application){

    private var mediaPlayer: MediaPlayer? = null

    private val _numbers = MutableStateFlow<List<Word>>(emptyList())
    val numbers: StateFlow<List<Word>> = _numbers

    private val _family = MutableStateFlow<List<Word>>(emptyList())
    val family: StateFlow<List<Word>> = _family

    private val _colors = MutableStateFlow<List<Word>>(emptyList())
    val colors: StateFlow<List<Word>> = _colors

    private val _phrases = MutableStateFlow<List<Word>>(emptyList())
    val phrases: StateFlow<List<Word>> = _phrases

    fun loadWords(category: String) {
        viewModelScope.launch {
            when (category) {
                "numbers" -> wordDao.getNumbers().collect { entities ->
                    _numbers.value = entities.toWordListNumbers()
                }
                "family" -> wordDao.getFamily().collect { entities ->
                    _family.value = entities.toWordListFamily()
                }
                "colors" -> wordDao.getColors().collect { entities ->
                    _colors.value = entities.toWordListColors()
                }
                "phrases" -> wordDao.getPhrases().collect { entities ->
                    _phrases.value = entities.toWordListPhrases()
                }
            }
        }
    }

    fun playAudio(audioResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(getApplication(), audioResId).apply {
            start()
            setOnCompletionListener {
                it.release()
                mediaPlayer = null
            }
        }
    }

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

}
