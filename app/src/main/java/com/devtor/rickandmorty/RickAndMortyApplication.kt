package com.devtor.rickandmorty

import android.app.Application
import com.devtor.rickandmorty.data.AppContainer
import com.devtor.rickandmorty.data.DefaultAppContainer

class RickAndMortyApplication (): Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}