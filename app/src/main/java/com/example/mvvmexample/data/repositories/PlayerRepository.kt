package com.example.mvvmexample.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.data.models.PlayHistory
import com.example.mvvmexample.data.network.Resource
import com.example.mvvmexample.data.services.PlayerService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlayerRepository(private val playerService: PlayerService) {

    fun getRecentlyPlayedTracks(limit: Int): MutableLiveData<Resource<List<PlayHistory>>> =
        MutableLiveData<Resource<List<PlayHistory>>>().apply {
            value = Resource.Loading()
            playerService.getRecentlyPlayedTracks(limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    value = Resource.Success(it)
                }, {
                    value = Resource.Failed(it)
                })
        }
}