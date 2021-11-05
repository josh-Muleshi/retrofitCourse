package com.example.retrofitcourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcourse.databinding.ListItemBinding

class PhotoAdapter(val comments: List<Comment>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val comment = comments[position]

        holder.binding.tvTitle.text = comment.name
        holder.binding.tvAlbumId.text = comment.body
    }

    override fun getItemCount() = comments.size

}