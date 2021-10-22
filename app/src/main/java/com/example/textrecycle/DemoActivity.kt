package com.example.textrecycle

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import com.example.textrecycle.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity(),MyAdapter.OnCardClickListener {
    private lateinit var binding: ActivityDemoBinding
    private var list= mutableListOf<ModelClass>()
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeData()
        inti()




        binding.btnPayment.setOnClickListener {
            Log.d("xxx", "height payment button ${binding.btnPayment.height} ")
            Log.d("xxx", "width payment button ${binding.btnPayment.width} ")
            Log.d("xxx", "measuredHeight payment ${binding.layoutPayment.height} ")
        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    private fun inti() {
        adapter= MyAdapter(this)
        adapter.addAll(list,true)
        binding.rvBottom.setHasFixedSize(true)
        binding.rvBottom.adapter= adapter
    }

    private fun makeData() {
        list.add(ModelClass("Burger0","120",false))
        list.add(ModelClass("Burger1","120",false))
        list.add(ModelClass("Burger2","120",false))
        list.add(ModelClass("Burger3","120",false))
        list.add(ModelClass("Burger4","120",false))
        list.add(ModelClass("Burger5","120",false))
        list.add(ModelClass("Burger6","120",false))
        list.add(ModelClass("Burger7","120",false))
        list.add(ModelClass("Burger8","120",false))
        list.add(ModelClass("Burger9","120",false))
        list.add(ModelClass("Burger10","120",false))
        list.add(ModelClass("Burger11","120",false))
        list.add(ModelClass("Burger12","120",false))
        list.add(ModelClass("Burger13","120",false))
        list.add(ModelClass("Burger14","120",false))
        list.add(ModelClass("Burger15","120",false))
        list.add(ModelClass("Burger16","120",false))
        list.add(ModelClass("Burger17","120",false))
        list.add(ModelClass("Burger18","120",false))
        list.add(ModelClass("Burger19","120",false))
        list.add(ModelClass("Burger20","120",false))
        list.add(ModelClass("Burger21","120",false))
        list.add(ModelClass("Burger22","120",false))
        list.add(ModelClass("Burger23","120",false))
        list.add(ModelClass("Burger24","120",false))
        list.add(ModelClass("Burger25","120",false))
        list.add(ModelClass("Burger26","120",false))
        list.add(ModelClass("Burger27","120",false))
        list.add(ModelClass("Burger28","120",false))
        list.add(ModelClass("Burger29","120",false))
        list.add(ModelClass("Burger30","120",false))

    }

    override fun onCardClick(position: Int, name: String) {

    }
}