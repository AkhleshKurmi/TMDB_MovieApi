package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName

data class TvSerialList (

    @SerializedName("results")
    var Results:ArrayList<TvSerialResult>

)
