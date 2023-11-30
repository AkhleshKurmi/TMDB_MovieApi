package com.example.tmdbmovieapi.Activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapi.Adapter.TvListAdapter
import com.example.tmdbmovieapi.Interface.OntvListItemClickListner
import com.example.tmdbmovieapi.Model.TvSerialList
import com.example.tmdbmovieapi.R
import com.example.tmdbmovieapi.ViewModel.MyViewModel
import com.example.tmdbmovieapi.databinding.ActivityTvSerialListBinding

class TvSerialListActivity : AppCompatActivity() {
    lateinit var binding :ActivityTvSerialListBinding
    lateinit var myViewModel: MyViewModel
    lateinit var myTvSeriaListAdapter: TvListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_serial_list)

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
      binding.tvSerialRv.layoutManager = LinearLayoutManager(this)
        myViewModel.GetTvserial().observe(this, Observer {
            myTvSeriaListAdapter = TvListAdapter(it,object : OntvListItemClickListner{
                override fun onTvSerialClick(Position: Int, TvSerialList: TvSerialList) {

                    var moviedetail = TvSerialList.Results[Position]
                    var bundle = Bundle()

                    bundle.putString("title",moviedetail.Name)
                    bundle.putString("imgsrc",moviedetail.posterPath)
                    bundle.putString("overview",moviedetail.OverView)
                    bundle.putString("releasedate",moviedetail.FirstAirDate)
                    bundle.putDouble("rating",moviedetail.Rating)
                    bundle.putLong("ratingCount",moviedetail.TotleRating)
                    bundle.putString("language",moviedetail.language)
                    bundle.putDouble("popularity",moviedetail.Popularity)


                    TvSerialDetail(bundle)

                }

            })

            binding.tvSerialRv.adapter = myTvSeriaListAdapter
            myTvSeriaListAdapter.notifyDataSetChanged()
        })
    }

    fun TvSerialDetail(bundle: Bundle){
        var intent = Intent(this, MovieDetails::class.java)
        intent.putExtra("bundle",bundle)
        startActivity(intent)
    }
}