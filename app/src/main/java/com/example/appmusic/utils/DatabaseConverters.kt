package com.example.appmusic.utils

import androidx.room.TypeConverter
import com.example.appmusic.model.Song
import com.example.appmusic.model.SongsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class SongsPricesConverter {

    @Inject
    lateinit var gson: Gson

    @TypeConverter
    fun fromString(value: String): List<Song> {
        val listType: Type = object : TypeToken<List<Song>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Song>): String {
        return gson.toJson(list)
    }
}

class SongsImagesConverter {

    @Inject
    lateinit var gson: Gson

    @TypeConverter
    fun fromString(value: String): List<SongsResponse> {
        val listType: Type = object : TypeToken<List<SongsResponse>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<SongsResponse>): String {
        return gson.toJson(list)
    }
}