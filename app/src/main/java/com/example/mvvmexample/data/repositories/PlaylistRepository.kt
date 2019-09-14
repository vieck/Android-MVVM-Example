package com.example.mvvmexample.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.data.models.Playlist
import com.example.mvvmexample.data.network.Resource
import com.example.mvvmexample.data.services.PlaylistService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlaylistRepository(val playlistService: PlaylistService) {
    fun getUserPlaylists(limit: Int): LiveData<Resource<List<Playlist>>> =
        MutableLiveData<Resource<List<Playlist>>>().apply {
            value = Resource.Loading()
            playlistService.getUserPlaylists(limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    value = Resource.Success(it.items)
                }, {
                    value = Resource.Failed(it)
                })
        }
}