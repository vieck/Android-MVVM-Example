package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.ITrack

data class Track(
    override val album: Album
) : ITrack