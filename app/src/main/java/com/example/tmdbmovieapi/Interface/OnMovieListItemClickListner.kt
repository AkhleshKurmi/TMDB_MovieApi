package com.example.tmdbmovieapi.Interface

import com.example.tmdbmovieapi.Model.MovieList
import com.example.tmdbmovieapi.Model.TvSerialList

interface OnMovieListItemClickListner {
    fun onItemClick(Position:Int, MovieList:MovieList)

}