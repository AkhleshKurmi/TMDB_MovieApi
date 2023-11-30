package com.example.tmdbmovieapi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tmdbmovieapi.Model.PersonKnownFor
import com.example.tmdbmovieapi.Model.PersonResult
import com.example.tmdbmovieapi.databinding.CustomItemPersonKnownForBinding
import com.squareup.picasso.Picasso

class PersonKnownForRvAdapter(var list : PersonResult) : Adapter<PersonKnownForRvAdapter.myViewHolder>() {

    inner class myViewHolder(var binding : CustomItemPersonKnownForBinding) :ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var binding = CustomItemPersonKnownForBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.knownFor.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var known = list.knownFor[position]

        holder.binding.overView.text = "OverView - ${known.overview}"
        holder.binding.titleKnown.text = "Title - ${known.Title}"
        holder.binding.releaseDateKnown.text = "Release Date - ${known.ReleaseDate}"
        holder.binding.totleRating.text = "Rating Count - ${known.RatingCount}"

        var ratingCount = known.Rating

        holder.binding.rating.text = "Rating - $ratingCount"
        holder.binding.ratingbarKnown.rating = ratingCount.toFloat()/2
        var imgstart = "https://image.tmdb.org/t/p/w500/"
        Picasso.get().load("$imgstart${known.Image}").into(holder.binding.knownImage)
    }
}