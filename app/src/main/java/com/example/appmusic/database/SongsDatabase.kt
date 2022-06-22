package com.example.appmusic.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appmusic.domain.DomainSong
import com.example.appmusic.utils.SongsImagesConverter
import com.example.appmusic.utils.SongsPricesConverter


@Database(
    entities = [DomainSong::class],
    version = 1
)

@TypeConverters(
    SongsPricesConverter::class,
    SongsImagesConverter::class
)
abstract class SongsDatabase : RoomDatabase() {
    abstract fun getSongsDAO(): SongsDAO
}