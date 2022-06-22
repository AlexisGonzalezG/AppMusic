package com.example.appmusic.DI

import com.example.appmusic.MainActivity
import com.example.appmusic.view.AllSongsFragment
import com.example.appmusic.view.DetailsFragment
import dagger.Component

@Component(

  modules = [
      ApplicationModule::class,
      RestModule::class,
      RepositoryModule::class,
      PresentersModule::class
    ]
)

interface SongsComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(allSongsFragment: AllSongsFragment)
    fun inject(detailsFragment: DetailsFragment)

}