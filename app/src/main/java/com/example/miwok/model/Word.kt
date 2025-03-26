package com.example.miwok.model

//Kreirana Word model klasa, stavio sam imageResourceId na null kada nema slike u layoutu pa nema sta ni ucitati
data class Word(val miwokTranslation: String, val defaultTranslation: String, val imageResourceId: Int? = null, val audioResourceId: Int)

//word extensions sam ovdje premjestio
fun List<NumbersEntity>.toWordListNumbers(): List<Word> {
    return map {
        Word(
            miwokTranslation = it.miwokTranslation,
            defaultTranslation = it.defaultTranslation,
            imageResourceId = it.imageResourceId,
            audioResourceId = it.audioResourceId
        )
    }
}
//nova lista objekata tipa word gdje svaki objekat sadrzi podatke preuzete iz entity numbers

fun List<ColorsEntity>.toWordListColors(): List<Word> {
    return map {
        Word(
            miwokTranslation = it.miwokTranslation,
            defaultTranslation = it.defaultTranslation,
            imageResourceId = it.imageResourceId,
            audioResourceId = it.audioResourceId
        )
    }
}

fun List<FamilyEntity>.toWordListFamily(): List<Word> {
    return map {
        Word(
            miwokTranslation = it.miwokTranslation,
            defaultTranslation = it.defaultTranslation,
            imageResourceId = it.imageResourceId,
            audioResourceId = it.audioResourceId
        )
    }
}

fun List<PhrasesEntity>.toWordListPhrases(): List<Word> {
    return map {
        Word(
            miwokTranslation = it.miwokTranslation,
            defaultTranslation = it.defaultTranslation,
            imageResourceId = null, // jer nemaju slike
            audioResourceId = it.audioResourceId
        )
    }
}