package com.example.tmdbmovieapi.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.databinding.ActivityMovieDetailsBinding
import com.squareup.picasso.Picasso

class MovieDetails : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details)

        var data = intent
        var startUrl = "https://image.tmdb.org/t/p/w500/"
        var bundle = data.getBundleExtra("bundle")

        binding.detailTitle.text = "Title - ${bundle!!.getString("title")}"
        binding.detailsLang.text= "Language - ${bundle!!.getString("language")}"

        Picasso.get().load("$startUrl${bundle!!.getString("imgsrc")}").into(binding.detailsIv)

        binding.detailsAdulttype.text = "Adult Type - ${bundle.getBoolean("adulttype")}"
        binding.detailsPopularity.text = "Popularity - ${bundle.getDouble("popularity")}"
        binding.detailsTotalRating.text = "Total Rating - ${bundle.getLong("ratingCount")}"
        binding.detailsReleaseDate.text = "Release Date - ${bundle.getString("releasedate")}"
        binding.detailsOverView.text = "OverView - ${bundle.getString("overview")}"

        var rating = bundle.getDouble("rating")
//        binding.ratingBar.max = 10
        binding.ratingBar.rating = rating.toFloat()/2

        binding.detailsRating.text = "Rating - $rating"

//        var title = data.getStringExtra("title")
//        var imagesrc = data.getStringExtra("image")
//        var adulttype = data.getBooleanExtra("adult_type",false)
//        var releaseDate = data.
    }
}