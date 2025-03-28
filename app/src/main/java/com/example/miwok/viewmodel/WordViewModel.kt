package com.example.miwok.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miwok.model.Category
import com.example.miwok.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val wordDao: WordDao
    ) : ViewModel() {

    private var mediaPlayer: MediaPlayer? = null

    private val _numbers = MutableStateFlow<List<Word>>(emptyList())
    val numbers: StateFlow<List<Word>> = _numbers

    private val _family = MutableStateFlow<List<Word>>(emptyList())
    val family: StateFlow<List<Word>> = _family

    private val _colors = MutableStateFlow<List<Word>>(emptyList())
    val colors: StateFlow<List<Word>> = _colors

    private val _phrases = MutableStateFlow<List<Word>>(emptyList())
    val phrases: StateFlow<List<Word>> = _phrases


    fun loadWords(category: Category) {
        viewModelScope.launch {
            when (category) {
                Category.NUMBERS -> wordDao.getNumbers().collectLatest { entities ->
                    _numbers.value = entities.toWordListNumbers()
                }
                Category.FAMILY -> wordDao.getFamily().collectLatest { entities ->
                    _family.value = entities.toWordListFamily()
                }
                Category.COLORS -> wordDao.getColors().collectLatest { entities ->
                    _colors.value = entities.toWordListColors()
                }
                Category.PHRASES -> wordDao.getPhrases().collectLatest { entities ->
                    _phrases.value = entities.toWordListPhrases()
                }
            }
        }
    }


    fun playAudio(audioResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, audioResId).apply {
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
