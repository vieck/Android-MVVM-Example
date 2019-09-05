package com.example.mvvmexample.home.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.home.R
import com.example.mvvmexample.data.models.PlayHistory
import kotlinx.android.synthetic.main.listitem_track_small.view.*

class AlbumAdapter(private val context: Context) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    private var albums: List<PlayHistory> = listOf()

    fun setAlbums(albums: List<PlayHistory>) {
        this.albums = albums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem_track_small, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = albums[position]
        val albumImageUrl = item.track.album.images.first().url
        Glide.with(context).load(albumImageUrl).into(holder.trackImage)
        holder.name.text = item.track.name
    }

    inner class AlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val trackImage: ImageView = itemView.trackImage
        val name: TextView = itemView.albumName
    }
}