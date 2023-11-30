package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName


data class MovieList(

   @SerializedName("results")
    var Results:List<ResultsMovie>
)

data class ResultsMovie(
    @SerializedName("adult")
    var AdultType: Boolean,

    @SerializedName("backdrop_path")
    var backDropPath :String,
    @SerializedName("id")
    var MovieId:Long,

    @SerializedName("original_language")
    var language:String,

    @SerializedName("original_title")
    var Title : String,

    @SerializedName("overview")
    var OverView: String,

    @SerializedName("popularity")
    var Popularity :Double,

    @SerializedName("poster_path")
    var posterPath : String,

    @SerializedName("release_date")
    var ReleaseDate: String,

    @SerializedName("vote_average")
    var Rating:Double,

    @SerializedName("vote_count")
    var TotleRating :Long
)


