package com.example.unilink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unilink.Data.HorizontalData
import com.example.unilink.adapter.HorizontalAdapter
import com.example.unilink.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

//        binding.home1.setOnClickListener{
//            startActivity(Intent(this,StudentHomeActivity::class.java))
//        }

        val exampleList = generateList(10)

        horizontalAdapter = HorizontalAdapter(this, exampleList)
        binding.recyclerView.adapter = horizontalAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        binding.recyclerView.setHasFixedSize(true)
    }


    private fun generateList(size: Int) : MutableList<HorizontalData>
    {
        val list = mutableListOf<HorizontalData>()

        for ( i in 0 until size ) {
            list.add(HorizontalData("Indian Institute of Technology Bombay ${i+1}"))
        }
        return list
    }


}