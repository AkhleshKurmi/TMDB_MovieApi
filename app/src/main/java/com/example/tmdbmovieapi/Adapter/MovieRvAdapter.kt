package com.example.tmdbmovieapi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tmdbmovieapi.Interface.OnMovieListItemClickListner
import com.example.tmdbmovieapi.Model.MovieList
import com.example.tmdbmovieapi.databinding.CustomListViewMoviesBinding
import com.squareup.picasso.Picasso

class MovieRvAdapter(var list :MovieList, var onItemClick : OnMovieListItemClickListner) : Adapter<MovieRvAdapter.myViewHolder>()  {

    inner class myViewHolder (var binding :CustomListViewMoviesBinding) :ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var binding = CustomListViewMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.Results.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var imgstart = "https://image.tmdb.org/t/p/w500/"
        var movies = list.Results[position]
        holder.binding.title.text ="Title   :  "+ movies.Title
        Picasso.get().load("$imgstart${movies.posterPath}").into(holder.binding.imageView)
        holder.binding.language.text = "Language   :  ${movies.language}"

        holder.itemView.setOnClickListener{
            onItemClick.onItemClick(position,list)
        }
    }


}

