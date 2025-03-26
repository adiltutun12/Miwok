package com.example.miwok.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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
