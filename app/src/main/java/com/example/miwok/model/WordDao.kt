package com.example.miwok.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM numbers")
    fun getNumbers() : Flow<List<NumbersEntity>>

    @Query("SELECT * FROM family")
    fun getFamily() : Flow<List<FamilyEntity>>

    @Query("SELECT * FROM colors")
    fun getColors() : Flow<List<ColorsEntity>>

    @Query("SELECT * FROM phrases")
    fun getPhrases() : Flow<List<PhrasesEntity>>
}