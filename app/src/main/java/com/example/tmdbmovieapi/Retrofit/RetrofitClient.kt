package com.example.tmdbmovieapi.Retrofit

import com.example.tmdbmovieapi.Model.ApiMethods
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private val retrofitClient : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create(Gson()))


    }

    val ApiCall : ApiMethods by lazy {
        retrofitClient.build().create(ApiMethods::class.java)
    }
}