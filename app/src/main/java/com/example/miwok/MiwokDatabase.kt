package com.example.miwok

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.miwok.ColorsEntity
import com.example.miwok.FamilyEntity
import com.example.miwok.NumbersEntity
import com.example.miwok.PhrasesEntity
import com.example.miwok.WordDao

@Database(
    entities = [
        NumbersEntity::class,
        FamilyEntity::class,
        ColorsEntity::class,
        PhrasesEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MiwokDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao


    companion object {
        @Volatile private var INSTANCE: MiwokDatabase? = null

        fun getDatabase(context: Context): MiwokDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MiwokDatabase::class.java,
                    "miwok_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
