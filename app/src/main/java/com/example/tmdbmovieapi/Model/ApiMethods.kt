package com.example.tmdbmovieapi.Model

import com.example.tmdbmovieapi.Response.MovieDataList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiMethods{

//    @Headers("Authorization:Bearer 1824fefb7acb2b5d2fa6c0e794ead163")
    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") apiKey:String): Call<MovieList>


    @GET("/3/tv/popular")
    fun getTvSerial(@Query("api_key") apiKey:String) :Call<TvSerialList>

    @GET("/3/person/popular")
    fun getPerson(@Query("api_key") apiKey: String) : Call<PersonData>
}