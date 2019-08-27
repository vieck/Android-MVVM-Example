package com.example.mvvmexample.data.repositories

import com.example.mvvmexample.data.services.PlayerService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlayerRepository(private val playerService: PlayerService) {

    fun getRecentlyPlayedTracks(limit: Int): Flowable<Any> {
        return playerService.getRecentlyPlayedTracks(limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}