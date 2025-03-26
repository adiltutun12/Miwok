package com.example.miwok.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers")
data class NumbersEntity(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val miwokTranslation: String,
    val defaultTranslation: String,
    val imageResourceId : Int?,
    val audioResourceId: Int
)
