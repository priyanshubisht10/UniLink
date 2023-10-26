package com.example.unilink.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unilink.Data.HorizontalData
import com.example.unilink.R
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso


class HorizontalAdapter(val context: Context, private val element:MutableList<HorizontalData>): RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recycler_view,parent,false)
        return HorizontalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return element.size
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val currentItem=element[position]
        currentItem.institutename.also { holder.institutename.text = it }


        FirebaseStorage.getInstance().reference.child("profile").child("logo.jpg").downloadUrl.addOnSuccessListener { uri ->
            val imageUrl = uri.toString()

            Picasso.get().load(imageUrl).into(holder.imageView)
        }


    }
    inner class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val institutename = view.findViewById<TextView>(R.id.institutename)!!
        val imageView: ImageView = itemView.findViewById(R.id.circularImageView)



    }



}