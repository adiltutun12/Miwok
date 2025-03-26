package com.example.miwok.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "family")
data class FamilyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val miwokTranslation: String,
    val defaultTranslation: String,
    val imageResourceId : Int?,
    val audioResourceId: Int
)
