package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName

data class PersonData(
    @SerializedName("results")
    var Results :ArrayList<PersonResult>
)




