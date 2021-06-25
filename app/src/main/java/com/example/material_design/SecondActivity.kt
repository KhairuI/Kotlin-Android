package com.example.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.material_design.databinding.ActivitySecondBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.bottomBar)
        binding.bottomBar.setNavigationOnClickListener {
            binding.bottomBar.fabAlignmentMode= BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }
        
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.bottom_app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.setting ->{
                shawSnackBar("Settings")
            }
           R.id.profile ->{
               shawSnackBar("Profile")
           }
            R.id.messId ->{
                shawSnackBar("Message")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun shawSnackBar(message:String){
        Snackbar.make(binding.topLayout,message,Snackbar.LENGTH_SHORT).show()
    }
}