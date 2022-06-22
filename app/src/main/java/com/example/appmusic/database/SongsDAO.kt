package com.example.appmusic.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appmusic.domain.DomainSong
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SongsDAO {
    //Here we can to do ,everything that we need , Querys

    @Query("SELECT * FROM songs_table")
    fun getAllSongs(): Single<List<DomainSong>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSongs(vararg songs:DomainSong):Completable

    @Query("SELECT * FROM songs_table WHERE artistId LIKE :artistId")
    fun getSongById(artistId:Int):Single <DomainSong>

}