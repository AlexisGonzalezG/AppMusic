package com.example.appmusic.rest

import com.example.appmusic.model.SongsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SongServiceApi {
    @GET(SONG_PATH)
    fun getSongs(): Single<SongsResponse>

    //https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50

    companion object{

        const val  BASE_URL = "https://itunes.apple.com/"
        private const val SONG_PATH = "search?term=pop&amp;media=music&amp;entity=song&amp;limit=50"


    }

}