package com.example.unilink.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.unilink.Data.ExampleItem
import com.example.unilink.R
import com.example.unilink.SecondActivity
import com.example.unilink.utils.Constants


class ExampleAdaptor(val context: Context, val element: MutableList<ExampleItem>) :
    RecyclerView.Adapter<ExampleAdaptor.ExamViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ExamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return element.size
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        val currentItem = element[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }


    inner class ExamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById<TextView>(R.id.title_view)
        val description: TextView = view.findViewById(R.id.description_view)

        init {
            view.setOnClickListener {

                val title = view.findViewById<TextView>(R.id.title_view)

                val position = adapterPosition
                val item = element[position]
                Toast.makeText(context, "${title.text} was clicked", Toast.LENGTH_SHORT).show()

                val intent = Intent(context, SecondActivity::class.java)




                intent.putExtra(Constants.KEY_TITLE, item.title)
                intent.putExtra(Constants.KEY_DESCRIPTION, item.description)

                context.startActivity(intent)


            }
        }

    }
}