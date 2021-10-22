package com.example.textrecycle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.textrecycle.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(),MyAdapter.OnCardClickListener {

    private lateinit var binding: ActivityMainBinding
    private var list= mutableListOf<ModelClass>()
    private lateinit var adapter: MyAdapter
    var position=0
    var isClick=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeData()
        makeTab()
        inti()
        //binding.recycle.layoutManager!!.smoothScrollToPosition(binding.recycle,RecyclerView.)

        //binding.recycle.layoutManager!!.smoothScrollToPosition(binding.recycle, RecyclerView.State(), 14)

        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                position= tab?.position!!
                Log.d("xxx", "onTabSelected: $position")
                binding.recycle.scrollToPosition(position)

                //binding.recycle.getChildAt(position)
               // binding.recycle.scrollTo(0,position)

               // binding.recycle.smoothScrollToPosition(position!!)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    private fun makeTab() {

        binding.tabLayout.apply {
            addTab(binding.tabLayout.newTab().setText("Burger0"))
            addTab(binding.tabLayout.newTab().setText("Burger1"))
            addTab(binding.tabLayout.newTab().setText("Burger2"))
            addTab(binding.tabLayout.newTab().setText("Burger3"))
            addTab(binding.tabLayout.newTab().setText("Burger4"))
            addTab(binding.tabLayout.newTab().setText("Burger5"))
            addTab(binding.tabLayout.newTab().setText("Burger6"))
            addTab(binding.tabLayout.newTab().setText("Burger7"))
            addTab(binding.tabLayout.newTab().setText("Burger8"))
            addTab(binding.tabLayout.newTab().setText("Burger9"))
            addTab(binding.tabLayout.newTab().setText("Burger10"))
            addTab(binding.tabLayout.newTab().setText("Burger11"))
            addTab(binding.tabLayout.newTab().setText("Burger12"))
            addTab(binding.tabLayout.newTab().setText("Burger13"))
            addTab(binding.tabLayout.newTab().setText("Burger14"))
            addTab(binding.tabLayout.newTab().setText("Burger15"))
            addTab(binding.tabLayout.newTab().setText("Burger16"))
            addTab(binding.tabLayout.newTab().setText("Burger17"))
            addTab(binding.tabLayout.newTab().setText("Burger18"))
            addTab(binding.tabLayout.newTab().setText("Burger19"))
            addTab(binding.tabLayout.newTab().setText("Burger20"))
            addTab(binding.tabLayout.newTab().setText("Burger21"))
            addTab(binding.tabLayout.newTab().setText("Burger22"))
            addTab(binding.tabLayout.newTab().setText("Burger23"))
            addTab(binding.tabLayout.newTab().setText("Burger24"))
            addTab(binding.tabLayout.newTab().setText("Burger25"))
            addTab(binding.tabLayout.newTab().setText("Burger26"))
            addTab(binding.tabLayout.newTab().setText("Burger27"))
            addTab(binding.tabLayout.newTab().setText("Burger28"))
            addTab(binding.tabLayout.newTab().setText("Burger29"))
            addTab(binding.tabLayout.newTab().setText("Burger30"))
        }


    }

    private fun inti() {
        adapter= MyAdapter(this)
        adapter.addAll(list,true)
        binding.recycle.setHasFixedSize(true)
        binding.recycle.adapter= adapter

        binding.recycle.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy>0){

                    //Snackbar.make(binding.rootLayout," $dy Scroll down",Snackbar.LENGTH_SHORT).show()
                }
                else if (dy < 0) {
                    //Snackbar.make(binding.rootLayout,"$dy Scroll Up",Snackbar.LENGTH_SHORT).show()
                }
                //Snackbar.make(binding.rootLayout,"$x",Snackbar.LENGTH_SHORT).show()
                val manager= binding.recycle.layoutManager as LinearLayoutManager

                    position= manager.findFirstVisibleItemPosition()

                    binding.tabLayout.getTabAt(position)?.select()


                Log.d("xxx", "position scroll : $position")

               // Snackbar.make(binding.rootLayout,"${list[position].name}",Snackbar.LENGTH_SHORT).show()

            }

            /*override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState === RecyclerView.SCROLL_STATE_IDLE) {
                    //Snackbar.make(binding.rootLayout,"SCROLL_STATE_IDLE",Snackbar.LENGTH_SHORT).show()
                }
                else if(newState === RecyclerView.SCROLL_STATE_SETTLING){
                    //Snackbar.make(binding.rootLayout,"SCROLL_STATE_SETTLING",Snackbar.LENGTH_SHORT).show()
                }

            }*/
        })
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

    override fun onCardClick(position: Int, name:String) {

        Log.d("xxx", "position: $position Name: $name ")
    }
}