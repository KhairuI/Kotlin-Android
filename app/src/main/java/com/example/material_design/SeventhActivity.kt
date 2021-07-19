package com.example.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.material_design.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController= Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding.bottomNavigation,navController)
    }
}