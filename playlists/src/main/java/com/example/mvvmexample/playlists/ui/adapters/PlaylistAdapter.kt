package com.example.mvvmexample.playlists.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.data.models.Playlist
import com.example.mvvmexample.playlists.R
import kotlinx.android.synthetic.main.listitem_playlist.view.*

class PlaylistAdapter(private val context: Context): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
    private var playlists: List<Playlist> = listOf()

    fun setPlaylists(playlists: List<Playlist>) {
        this.playlists = playlists
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun getItemCount(): Int = playlists.size

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        val imageUrl = playlist.images.first().url
        Glide.with(context).load(imageUrl).into(holder.image)
        holder.name.text = playlist.name
    }

    inner class PlaylistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.image
        val name: TextView = itemView.name
    }
}