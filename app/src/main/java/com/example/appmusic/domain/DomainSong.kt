package com.example.appmusic.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appmusic.model.Song


@Entity(tableName = "songs_table")
data class DomainSong(

    @PrimaryKey
    val artistId: Int,
    val songId: Int,
    val artistsName: String,
    val collectionName: String,
    val artWorkUrl60: String,
    val trackPrice: Double
    // val level: String
)

fun List<Song>.mapToDomainSong(): List<DomainSong> {
    return this.map { networkSong ->

        DomainSong(
            artistId = networkSong.artistId ?: 0,
            songId = networkSong.trackId ?: 0,
            artistsName = networkSong.artistName ?: "Unknown Artistname",
            collectionName = networkSong.collectionName ?: "Unknown Collectionname",
            artWorkUrl60 = networkSong.artworkUrl60 ?: "Unknown Image",
            trackPrice = networkSong.trackPrice ?: 00000.00
        )
    }
}




