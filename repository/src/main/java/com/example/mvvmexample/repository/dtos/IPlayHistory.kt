package com.example.mvvmexample.repository.dtos

interface IPlayHistory {
    val track: ITrack
    val playedAt: String
    val context: ISpotifyContext
}