package com.example.miwok.model

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMiwokDatabase(application: Application): MiwokDatabase {
        return MiwokDatabase.getDatabase(application)
    }

    @Provides
    fun provideWordDao(database: MiwokDatabase): WordDao {
        return database.wordDao()
    }
}




