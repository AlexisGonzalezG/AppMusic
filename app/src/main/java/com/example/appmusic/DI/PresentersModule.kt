package com.example.appmusic.DI

import com.example.appmusic.presenters.AllSongsPresenter
import com.example.appmusic.presenters.AllSongsPresenterContract
import dagger.Binds
import dagger.Module

@Module
abstract class PresentersModule {

    @Binds
    abstract fun providesAllSongsPresenter(
        allSongsPresenter: AllSongsPresenter
    ): AllSongsPresenterContract
}