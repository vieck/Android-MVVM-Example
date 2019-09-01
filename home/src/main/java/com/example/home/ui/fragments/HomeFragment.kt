package com.example.home.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.home.R
import com.example.home.ui.di.injectFeature
import com.example.home.ui.viewmodels.HomeViewModel
import com.example.mvvmexample.data.network.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectFeature()
        setupObservers()
    }

    private fun setupObservers() {
        homeViewModel.recentlyPlayedTracks.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> Toast.makeText(context, "Length: " + it.data.size, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
