package com.example.tmdbmovieapi.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapi.Adapter.PopularPersonRvAdapter
import com.example.tmdbmovieapi.Interface.OnPersonClickListiner
import com.example.tmdbmovieapi.Model.PersonData
import com.example.tmdbmovieapi.Model.PersonKnownFor
import com.example.tmdbmovieapi.Model.PersonResult
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.ViewModel.MyViewModel
import com.example.tmdbmovieapi.databinding.ActivityPopularPersonListBinding

class PopularPersonListActivity : AppCompatActivity() {
   private lateinit var binding : ActivityPopularPersonListBinding
   private lateinit var myViewModel: MyViewModel
   private lateinit var myAdapter: PopularPersonRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_popular_person_list)
        binding.popularPersonRv.layoutManager = LinearLayoutManager(this)
       myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        var progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Loading, Please wait...")

        myViewModel.isloading.observe(this, Observer{
            if (it){
                progressDialog.show()
            }else {
                progressDialog.dismiss()
            }
        })

        myViewModel.PopularPerson().observe(this, Observer {
        myAdapter = PopularPersonRvAdapter(it, object : OnPersonClickListiner{
            override fun onPersonClick(Position: Int, Persondata: PersonData) {

                personKnown(Position)
            }


        })
            binding.popularPersonRv.adapter = myAdapter
            myAdapter.notifyDataSetChanged()
        })

    }

    fun personKnown(position:Int){
        var intent = Intent(this, PersonKnownForActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
    }
}