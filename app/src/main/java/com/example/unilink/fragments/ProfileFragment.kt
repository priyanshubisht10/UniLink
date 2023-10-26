package com.example.unilink.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unilink.Data.ExampleItem
import com.example.unilink.adapter.ExampleAdaptor
import com.example.unilink.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    private lateinit var adaptor1: ExampleAdaptor
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        val exampleList = generateList(10)
        adaptor1 = ExampleAdaptor(requireContext(), exampleList)
        recyclerView.adapter = adaptor1
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

    }

    private fun generateList(size: Int): MutableList<ExampleItem> {
        val list = mutableListOf<ExampleItem>()

        for (i in 0 until size) {
            list.add(ExampleItem("Item ${i + 1}", description = "Description ${i + 1}"))
        }


        return list
    }

}