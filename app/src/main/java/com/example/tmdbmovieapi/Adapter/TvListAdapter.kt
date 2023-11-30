package com.example.tmdbmovieapi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbmovieapi.Interface.OnMovieListItemClickListner
import com.example.tmdbmovieapi.Interface.OntvListItemClickListner
import com.example.tmdbmovieapi.Model.TvSerialList
import com.example.tmdbmovieapi.databinding.CustomListViewMoviesBinding
import com.squareup.picasso.Picasso

class TvListAdapter (var list :TvSerialList, var onItemClick : OntvListItemClickListner) : RecyclerView.Adapter<TvListAdapter.myViewHolder>() {

    inner class myViewHolder(var binding: CustomListViewMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var binding =
            CustomListViewMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.Results.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var imgstart = "https://image.tmdb.org/t/p/w500/"
        var movies = list.Results[position]
        holder.binding.title.text = "Name   :  " + movies.Name
        Picasso.get().load("$imgstart${movies.posterPath}").into(holder.binding.imageView)
        holder.binding.language.text = "Language   :  ${movies.language}"

        holder.itemView.setOnClickListener {
            onItemClick.onTvSerialClick(position, list)
        }
    }
}