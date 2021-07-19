package com.example.material_design.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.material_design.R
import com.example.material_design.SeventhActivity
import com.example.material_design.databinding.FragmentMessageBinding
import com.google.android.material.snackbar.Snackbar


class MessageFragment : Fragment() {

    private lateinit var binding:FragmentMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding= FragmentMessageBinding.inflate(layoutInflater)
        binding.messageBtn.setOnClickListener {
            startActivity(Intent(activity,SeventhActivity::class.java))
        }
        return binding.root
       // return inflater.inflate(R.layout.fragment_message, container, false)
    }

    companion object {

    }

    fun shawSnackBar(message:String){
        Snackbar.make(binding.layoutTop,message, Snackbar.LENGTH_SHORT).show()
    }
}