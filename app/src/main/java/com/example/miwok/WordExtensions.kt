package com.example.miwok


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
            imageResourceId = null, // jer nemaju slike
            audioResourceId = it.audioResourceId
        )
    }
}