package com.example.appmusic.presenters

import com.example.appmusic.database.LocalDataRepository
import com.example.appmusic.domain.DomainSong
import com.example.appmusic.domain.mapToDomainSong
import com.example.appmusic.rest.SongsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AllSongsPresenter @Inject constructor(
    private val songsRepository: SongsRepository,
    private val compositeDisposable: CompositeDisposable,
    private val localSongsRepository: LocalDataRepository
): AllSongsPresenterContract{

    private var songsViewContract: AllSongsViewContract? = null

    override fun init(viewContract: AllSongsViewContract) {
        songsViewContract = viewContract
    }

    override fun registerToNetworkState() {
        TODO("Not yet implemented")
    }

    override fun getAllSongs() {
        songsViewContract?.loadingSongs(true)
        getSongsFromNetwork()
    }

    override fun destroyPresenter() {
        songsViewContract = null
        compositeDisposable.dispose()
    }

    private fun getSongsFromNetwork() {
        songsRepository.getAllSongs()
            .subscribeOn(Schedulers.io())
            .flatMapCompletable {
                localSongsRepository.insertSongs(it.songs.mapToDomainSong())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { getSongsFromDb() },
                { error ->
                   songsViewContract?.error(error)
                    getSongsFromDb()
                }
            )
            .also { compositeDisposable.add(it) }
    }

    private fun getSongsFromDb() {
        localSongsRepository.getAllSongs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { songsViewContract?.successSongsResponse(it, true) },
                { songsViewContract?.error(it) }
            )
            .also { compositeDisposable.add(it) }
    }

}

interface AllSongsPresenterContract{
    fun init(viewContract: AllSongsViewContract)
    fun registerToNetworkState()
    fun getAllSongs()
    fun destroyPresenter()
}

interface AllSongsViewContract{
    fun loadingSongs(isLoading: Boolean = false)
    fun successSongsResponse(songs: List<DomainSong>, isOffline: Boolean = false)
    fun error(error: Throwable)
}

