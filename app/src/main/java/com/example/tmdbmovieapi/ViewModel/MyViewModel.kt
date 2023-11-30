package com.example.tmdbmovieapi.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbmovieapi.Model.MovieList
import com.example.tmdbmovieapi.Model.PersonData
import com.example.tmdbmovieapi.Model.ResultsMovie
import com.example.tmdbmovieapi.Model.TvSerialList
import com.example.tmdbmovieapi.Repository.Repository
import com.example.tmdbmovieapi.Response.MovieDataList

class MyViewModel :ViewModel() {

    var repository : Repository = Repository()

    var isloading :MutableLiveData<Boolean> = repository.isLoading

    fun GetMovies (): LiveData<MovieList>{

        return repository.getMovies()
    }

    fun  GetTvserial():LiveData<TvSerialList>{
        return repository.getTvSerial()
    }

    fun  PopularPerson():LiveData<PersonData>{
        return repository.PopularPerson()
    }
}