package com.example.kotlin_multi_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_multi_recycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listUsers = mutableListOf<String>()
    private lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeData()
        adapter= MyAdapter(listUsers)
        binding.recycle.setHasFixedSize(true)
        binding.recycle.adapter= adapter

    }

    private fun makeData() {
        listUsers.add("uzzal")
        listUsers.add("uzzal_image")
        listUsers.add("partner")
        listUsers.add("partner_image")
        listUsers.add("uzzal")
        listUsers.add("partner")
        listUsers.add("uzzal")
        listUsers.add("uzzal_image")
        listUsers.add("partner")
        listUsers.add("partner_image")
        listUsers.add("partner_image")
        listUsers.add("uzzal")
        listUsers.add("uzzal_image")
        listUsers.add("partner")
        listUsers.add("partner_image")
    }
}