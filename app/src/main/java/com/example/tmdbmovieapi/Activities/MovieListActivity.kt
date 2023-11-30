package com.example.tmdbmovieapi.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapi.Adapter.MovieRvAdapter
import com.example.tmdbmovieapi.Interface.OnMovieListItemClickListner
import com.example.tmdbmovieapi.Model.MovieList
import com.example.tmdbmovieapi.Model.ResultsMovie
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.ViewModel.MyViewModel
import com.example.tmdbmovieapi.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {
    lateinit var binding : ActivityMovieListBinding
    lateinit var myViewModel: MyViewModel
    lateinit var MovieAdater : MovieRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_list)

        binding.rvMovies.layoutManager = LinearLayoutManager(this)


        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        var progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Loading, Please wait...")

        myViewModel.isloading.observe(this, Observer {
            if (it){
                progressDialog.show()
            }else {
               progressDialog.dismiss()
            }
        })

        myViewModel.GetMovies().observe(this, Observer {

//            Log.d("listsize", "ListSIze : ${it.size} ")
//             var list =
//            for (movies in it){
//             list.add(it)
//        }

            MovieAdater = MovieRvAdapter(it,object :OnMovieListItemClickListner{
                override fun onItemClick(Position: Int, MovieList: MovieList) {

                    var moviedetail = MovieList.Results[Position]
               var bundle = Bundle()

                    bundle.putString("title",moviedetail.Title)
                    bundle.putString("imgsrc",moviedetail.posterPath)
                    bundle.putString("overview",moviedetail.OverView)
                    bundle.putString("releasedate",moviedetail.ReleaseDate)
                    bundle.putDouble("rating",moviedetail.Rating)
                    bundle.putLong("ratingCount",moviedetail.TotleRating)
                    bundle.putString("language",moviedetail.language)
                    bundle.putDouble("popularity",moviedetail.Popularity)
                    bundle.putBoolean("adulttype",moviedetail.AdultType)

                    movieDetail(bundle)

//                    Toast.makeText(this@MovieListActivity, "clicked", Toast.LENGTH_SHORT).show()
                }

            })
            binding.rvMovies.adapter = MovieAdater
            MovieAdater.notifyDataSetChanged()
        })


    }
    fun movieDetail(bundle: Bundle){
        var intent = Intent(this, MovieDetails::class.java)
         intent.putExtra("bundle",bundle)
        startActivity(intent)
    }
}