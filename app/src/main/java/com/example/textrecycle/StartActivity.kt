package com.example.textrecycle

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.textrecycle.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val widthPX = Resources.getSystem().displayMetrics.widthPixels
        val heightPX = Resources.getSystem().displayMetrics.heightPixels
        Log.d("xxx", "height in px $heightPX")


        binding.btnRecycle.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding.btnSheet.setOnClickListener {
            startActivity(Intent(this,ButtonActivity::class.java))
        }

        binding.btnView.setOnClickListener {
            startActivity(Intent(this,DemoActivity::class.java))
        }
    }
}