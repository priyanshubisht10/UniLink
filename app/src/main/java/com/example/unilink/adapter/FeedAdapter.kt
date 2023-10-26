package com.example.unilink.adapter



import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unilink.Data.FeedData
import com.example.unilink.R


class FeedAdapter(val context: Context, private val element:MutableList<FeedData>): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.feed_recycler_view,parent,false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return element.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem=element[position]
        holder.institutename.text=currentItem.institutename
        holder.caption.text=currentItem.caption
    }
    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val institutename = view.findViewById<TextView>(R.id.instituename)!!
        val caption: TextView = view.findViewById(R.id.caption)


    }



}