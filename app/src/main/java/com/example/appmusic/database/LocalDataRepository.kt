package com.example.appmusic.database

import com.example.appmusic.domain.DomainSong
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

interface LocalDataRepository {
    fun getAllSongs(): Single<List<DomainSong>>
    fun insertSongs(songs: List<DomainSong>): Completable
    fun getSongById(songId: Int): Single<DomainSong>
}

class LocalDataRepositoryImpl @Inject constructor(

private val songsDAO: SongsDAO

): LocalDataRepository{
    override fun getAllSongs(): Single<List<DomainSong>> {
        return songsDAO.getAllSongs()
    }
    override fun insertSongs( songs:List<DomainSong>): Completable {
        return songsDAO.insertAllSongs(*songs.toTypedArray())
    }

    override fun getSongById(songId: Int): Single<DomainSong> {
        return songsDAO.getSongById(songId)
    }

}