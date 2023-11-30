package com.example.tmdbmovieapi.Interface

import com.example.tmdbmovieapi.Model.TvSerialList

interface OntvListItemClickListner {
    fun onTvSerialClick(Position: Int, TvSerialList: TvSerialList)
}