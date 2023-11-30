package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName

data class TvSerialResult(
    @SerializedName("first_air_date")
    var FirstAirDate : String,

    @SerializedName("name")
    var Name :String,

    @SerializedName("original_language")
    var language:String,


    @SerializedName("overview")
    var OverView: String,

    @SerializedName("popularity")
    var Popularity :Double,

    @SerializedName("poster_path")
    var posterPath : String,


    @SerializedName("vote_average")
    var Rating:Double,

    @SerializedName("vote_count")
    var TotleRating :Long
)

