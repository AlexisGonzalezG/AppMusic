package com.example.appmusic.DI

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.appmusic.database.SongsDAO
import com.example.appmusic.database.SongsDatabase
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule (private val application: Application){

    @Provides
    fun providesContext(): Context = application.applicationContext

    @Provides
    fun provideRoomDb(context: Context): SongsDatabase =
        Room.databaseBuilder(
            context,
            SongsDatabase::class.java,
            "songs-db"
        )
            //.addMigrations(MIGRATION_1_2)
            .build()

    @Provides
    fun providesSongsDAO(database: SongsDatabase): SongsDAO =
        database.getSongsDAO()
}