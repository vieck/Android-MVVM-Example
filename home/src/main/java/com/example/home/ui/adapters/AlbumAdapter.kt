package com.example.home.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    private var albums: List<Any> = listOf()

    fun setAlbums(albums: List<Any>) {
        this.albums = albums
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem_track_small, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = albums[position]
    }

    inner class AlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}