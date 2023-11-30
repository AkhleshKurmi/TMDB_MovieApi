package com.example.tmdbmovieapi.Model

import com.google.gson.annotations.SerializedName

data class PersonResult(
    @SerializedName("adult")
    var Adult :Boolean,

    @SerializedName("known_for")
    var knownFor: ArrayList<PersonKnownFor>,

    @SerializedName("known_for_department")
    var DepartMent:String,

    @SerializedName("name")
    var Name:String,

    @SerializedName("profile_path")
    var ProfileImage:String


)