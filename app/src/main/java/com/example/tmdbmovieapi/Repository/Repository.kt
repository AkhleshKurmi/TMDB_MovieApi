package com.example.tmdbmovieapi.Repository

import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapi.Model.MovieList
import com.example.tmdbmovieapi.Model.PersonData
import com.example.tmdbmovieapi.Model.TvSerialList
import com.example.tmdbmovieapi.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var isLoading :MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = true
    }


    var MoviesliveData :MutableLiveData<MovieList> = MutableLiveData<MovieList>()
    var TvSerialliveData :MutableLiveData<TvSerialList> = MutableLiveData<TvSerialList>()
    var PopularPersonData :MutableLiveData<PersonData> = MutableLiveData<PersonData>()
    var ApiKey = "1824fefb7acb2b5d2fa6c0e794ead163"
    fun getMovies(): MutableLiveData<MovieList>{

        val call = RetrofitClient.ApiCall.getMovies(ApiKey)

        call.enqueue(object : Callback<MovieList>{
            override fun onResponse(
                call: Call<MovieList>,
                response: Response<MovieList>
            ) {
                if (response.isSuccessful) {
                    MoviesliveData.value = response.body()

                    isLoading.value = false}
//                }else{
//                    isLoading.value = false
//                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
//                isLoading.value = false
            }


        })
        return MoviesliveData
    }

    fun getTvSerial(): MutableLiveData<TvSerialList>{
        val call = RetrofitClient.ApiCall.getTvSerial(ApiKey)
        call.enqueue(object : Callback<TvSerialList>{
            override fun onResponse(call: Call<TvSerialList>, response: Response<TvSerialList>) {
                if (response.isSuccessful){
                    TvSerialliveData.value = response.body()
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<TvSerialList>, t: Throwable) {
                isLoading.value = false
            }

        })
        return TvSerialliveData
    }

    fun PopularPerson(): MutableLiveData<PersonData>{
        val call = RetrofitClient.ApiCall.getPerson(ApiKey)
        call.enqueue(object : Callback<PersonData>{
            override fun onResponse(call: Call<PersonData>, response: Response<PersonData>) {
                if (response.isSuccessful){
                    PopularPersonData.value = response.body()
                    isLoading.value = false
                }
            }

            override fun onFailure(call: Call<PersonData>, t: Throwable) {
                isLoading.value = false
            }

        })
        return PopularPersonData
    }

}