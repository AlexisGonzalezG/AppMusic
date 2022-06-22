package com.example.appmusic.DI

import com.example.appmusic.database.LocalDataRepository
import com.example.appmusic.database.LocalDataRepositoryImpl
import com.example.appmusic.rest.SongsRepository
import com.example.appmusic.rest.SongsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideLocalRepository(
        localDataRepositoryImpl: LocalDataRepositoryImpl
    ): LocalDataRepository

    @Binds
    abstract fun provideNetworkRepository(
        networkRepositoryImpl: SongsRepositoryImpl
    ): SongsRepository

}