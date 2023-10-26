package com.example.prog_o_thonproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.unilink.Data.FeedData
import com.example.unilink.adapter.FeedAdapter
import com.example.unilink.databinding.FragmentHomeStudentBinding


class HomeStudent : Fragment() {
    private lateinit var feedAdapter: FeedAdapter
    private lateinit var binding: FragmentHomeStudentBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= FragmentHomeStudentBinding.inflate(layoutInflater,container,false)

        // Inflate the layout for this fragment
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val exampleList = generateList(10)

        feedAdapter = FeedAdapter(requireContext(), exampleList)
        binding.recyclerView.adapter = feedAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)

    }


    private fun generateList(size: Int) : MutableList<FeedData>
    {
        val list = mutableListOf<FeedData>()

        for ( i in 0 until size ) {
            list.add(FeedData("Indian Institute of Technology Bombay ${i+1}",caption="The 10 most important things I’ve learned: There is no right or wrong answer on the number of hours you need to work. Sometimes it takes 75 hours"))
        }


        return list
    }
}