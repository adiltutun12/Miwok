package com.example.miwok.viewmodel

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.miwok.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val database = MiwokDatabase.getDatabase(application)
    private val wordDao = database.wordDao()

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
