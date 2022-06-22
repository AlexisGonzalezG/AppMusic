package com.example.appmusic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appmusic.R
import com.example.appmusic.SongApp
import com.example.appmusic.domain.DomainSong
import com.example.appmusic.presenters.AllSongsPresenterContract
import com.example.appmusic.presenters.AllSongsViewContract
import javax.inject.Inject


class AllSongsFragment : Fragment(),AllSongsViewContract {

    @Inject
    lateinit var songsPresenter: AllSongsPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SongApp.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        songsPresenter.init(this)

        songsPresenter.registerToNetworkState()
        songsPresenter.getAllSongs()

        songsPresenter.destroyPresenter()
        return inflater.inflate(R.layout.fragment_all_songs, container, false)
    }

    override fun loadingSongs(isLoading: Boolean) {
        TODO("Not yet implemented")
    }

    override fun successSongsResponse(songs: List<DomainSong>, isOffline: Boolean) {
        TODO("Not yet implemented")
    }

    override fun error(error: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        songsPresenter.destroyPresenter()
    }


}