package com.example.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.material_design.databinding.ActivitySixthBinding
import com.example.material_design.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class SixthActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
    {

    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.drawerToolbar)
        title="Navigation Drawer"

        setDrawer()
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,MessageFragment()).commit()
            binding.navigationView.setCheckedItem(R.id.message_dr)
        }


    }

    private fun setDrawer() {
        val toogle= ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.drawerToolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        binding.navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.call_dr ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,CallFragment()).commit()
            }
            R.id.message_dr ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,MessageFragment()).commit()
            }
            R.id.upload_dr ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,InsertFragment()).commit()
            }
            R.id.setting_dr ->{
                shawSnackBar("Setting")
            }
            R.id.share_dr ->{
                shawSnackBar("Share")
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {
        super.onPointerCaptureChanged(hasCapture)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }

    fun shawSnackBar(message:String){
        Snackbar.make(binding.drawerLayout,message, Snackbar.LENGTH_SHORT).show()
    }


}