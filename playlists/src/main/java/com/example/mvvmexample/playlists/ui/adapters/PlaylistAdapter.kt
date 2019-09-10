package com.example.mvvmexample.playlists.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.data.models.Playlist
import com.example.mvvmexample.playlists.R

class PlaylistAdapter(private val context: Context): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
    private var playlists: List<Playlist> = listOf()

    fun setPlaylists(playlists: List<Playlist>) {
        this.playlists = playlists
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun getItemCount(): Int = playlists.size

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
    }

    inner class PlaylistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }
}