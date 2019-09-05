package com.example.mvvmexample.home.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.data.network.Resource
import com.example.mvvmexample.home.R
import com.example.mvvmexample.home.di.injectFeature
import com.example.mvvmexample.home.ui.adapters.AlbumAdapter
import com.example.mvvmexample.home.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeature()
        setupRecentlyPlayedRecyclerView()
        setupObservers()
    }

    private fun setupRecentlyPlayedRecyclerView() {
        albumAdapter = AlbumAdapter(context!!)
        recentlyPlayedRecyclerView.adapter = albumAdapter
        recentlyPlayedRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupObservers() {
        homeViewModel.recentlyPlayedTracks.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> albumAdapter.setAlbums(it.data.items)
            }
        })
    }


}
