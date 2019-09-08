package com.example.mvvmexample.playlists.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmexample.playlists.R
import com.example.mvvmexample.playlists.di.injectFeature
import com.example.mvvmexample.playlists.viewmodels.PlaylistViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class PlaylistFragment : Fragment() {
    private val playlistViewModel: PlaylistViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeature()
        observePlaylist()
    }

    private fun observePlaylist() {
        playlistViewModel.userPlaylists.observe(viewLifecycleOwner, Observer {

        })
    }
}
