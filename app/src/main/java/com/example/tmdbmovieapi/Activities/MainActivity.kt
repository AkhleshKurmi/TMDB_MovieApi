package com.example.tmdbmovieapi.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnMoviesList.setOnClickListener(this)
        binding.btnTvSerialList.setOnClickListener(this)
        binding.btnPopularPersonList.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_movies_list ->{
                var intent = Intent(this, MovieListActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_tv_serial_list ->{
                var intent = Intent(this, TvSerialListActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_popular_person_list ->{
                var intent = Intent(this, PopularPersonListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}