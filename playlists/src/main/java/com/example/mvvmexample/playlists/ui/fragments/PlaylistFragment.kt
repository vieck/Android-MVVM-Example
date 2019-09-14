package com.example.mvvmexample.playlists.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmexample.data.network.Resource
import com.example.mvvmexample.playlists.R
import com.example.mvvmexample.playlists.di.injectFeature
import com.example.mvvmexample.playlists.ui.adapters.PlaylistAdapter
import com.example.mvvmexample.playlists.viewmodels.PlaylistViewModel
import kotlinx.android.synthetic.main.fragment_playlist.*
import org.koin.android.viewmodel.ext.android.viewModel

class PlaylistFragment : Fragment() {
    private val playlistViewModel: PlaylistViewModel by viewModel()
    private lateinit var adapter: PlaylistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeature()
        setupPlaylistRecyclerView()
        observePlaylist()
    }

    private fun observePlaylist() {
        playlistViewModel.userPlaylists.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> adapter.setPlaylists(it.data)
            }
        })
    }

    private fun setupPlaylistRecyclerView() {
        adapter = PlaylistAdapter(context!!)
        playlistRecyclerView.layoutManager = GridLayoutManager(context, 2)
        playlistRecyclerView.adapter = adapter
    }
}
