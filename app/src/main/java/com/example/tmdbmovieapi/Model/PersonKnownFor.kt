package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName

data class PersonKnownFor(
    @SerializedName("media_type")
    var MediaType:String,
    @SerializedName("original_title")
    var Title : String,
    @SerializedName("overview")
    var overview :String,
    @SerializedName("poster_path")
    var Image :String,

    @SerializedName("release_date")
    var ReleaseDate: String,
    @SerializedName("vote_average")
    var Rating:Double,
    @SerializedName("vote_count")
    var RatingCount: Long
)
