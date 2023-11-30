package com.example.tmdbmovieapi.Interface

import com.example.tmdbmovieapi.Model.PersonData

interface OnPersonClickListiner {

    fun onPersonClick(Position:Int, Persondata:PersonData)
}