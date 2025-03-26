package com.example.miwok

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
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

    @Insert(onConflict = OnConflictStrategy.REPLACE) //za ubacivanje iz aplikace kada bih radio ovo potrebno imati
    suspend fun insertNumbers(list: List<NumbersEntity>)

}