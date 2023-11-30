package com.example.tmdbmovieapi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tmdbmovieapi.Interface.OnPersonClickListiner
import com.example.tmdbmovieapi.Model.PersonData
import com.example.tmdbmovieapi.databinding.CustomPopularPersonListBinding
import com.squareup.picasso.Picasso

class PopularPersonRvAdapter(var list : PersonData, var onclickperson:OnPersonClickListiner) : Adapter<PopularPersonRvAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding:CustomPopularPersonListBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = CustomPopularPersonListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.Results.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var person = list.Results[position]
        var imgstart = "https://image.tmdb.org/t/p/w500/"
        holder.binding.namePerson.text = "Name  -  ${person.Name}"
        holder.binding.personDepart.text = "Known For  -  ${person.DepartMent}"
        Picasso.get().load("$imgstart${person.ProfileImage}").into(holder.binding.personImage)

        holder.itemView.setOnClickListener{
            onclickperson.onPersonClick(position, list)
        }
    }
}