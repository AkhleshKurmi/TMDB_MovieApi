package com.example.tmdbmovieapi.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapi.Adapter.PersonKnownForRvAdapter
import com.example.tmdbmovieapi.Model.PersonData
import com.example.tmdbmovieapi.Model.PersonKnownFor
import com.example.tmdbmovieapi.Model.PersonResult
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.ViewModel.MyViewModel
import com.example.tmdbmovieapi.databinding.ActivityPersonKnownForBinding
import com.example.tmdbmovieapi.databinding.ActivityPopularPersonListBinding

class PersonKnownForActivity : AppCompatActivity() {
    lateinit var binding: ActivityPersonKnownForBinding
    lateinit var myAdapter: PersonKnownForRvAdapter
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  DataBindingUtil.setContentView(this,R.layout.activity_person_known_for)

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

       var data = intent

        var position = data.getIntExtra("position",0)
        binding.knownRv.layoutManager = LinearLayoutManager(this)
        myViewModel.PopularPerson().observe(this, Observer {
            myAdapter =PersonKnownForRvAdapter(it.Results[position])
            binding.knownRv.adapter = myAdapter
            myAdapter.notifyDataSetChanged()
        })



    }
}