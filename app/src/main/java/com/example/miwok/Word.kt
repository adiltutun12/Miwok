package com.example.miwok

data class Word(val miwokTranslation: String, val defaultTranslation: String, val imageResourceId: Int? = null, val audioResourceId: Int) // ? znači da može biti null uradio sam ovo radi slike jer u pgrases nema slika

// ovdje je kreirana Word model klasa