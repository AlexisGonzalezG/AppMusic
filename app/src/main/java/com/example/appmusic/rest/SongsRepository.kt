package com.example.appmusic.rest

import com.example.appmusic.model.SongsResponse
import com.example.appmusic.utils.convertDate
import io.reactivex.Single
import javax.inject.Inject

interface SongsRepository {

    fun getAllSongs(): Single<SongsResponse>

}

class SongsRepositoryImpl @Inject constructor(

    private val serviceApi: SongServiceApi

): SongsRepository{

    override fun getAllSongs(): Single<SongsResponse> {
        "mydate".convertDate()
        return serviceApi.getSongs()

    }

}
