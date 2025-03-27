package com.example.miwok.model

data class Word(val miwokTranslation: String,
                val defaultTranslation: String,
                val imageResourceId: Int? = null,
                val audioResourceId: Int)

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
            imageResourceId = null,
            audioResourceId = it.audioResourceId
        )
    }
}