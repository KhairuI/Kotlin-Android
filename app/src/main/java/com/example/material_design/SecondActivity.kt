package com.example.material_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import com.example.material_design.databinding.ActivitySecondBinding
import com.example.material_design.databinding.BottomSheetBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var bottomSheet: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.bottomBar)

        binding.bottomBar.setNavigationOnClickListener {
            binding.bottomBar.fabAlignmentMode= BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }

        binding.btnBottomSheet.setOnClickListener {

            openBottomSheet()
        }
        binding.insertBtn.setOnClickListener {
            startActivity(Intent(this,ThirdActivity::class.java))
        }
        
    }

    private fun openBottomSheet() {
        bottomSheet= BottomSheetDialog(this)
        val view= LayoutInflater.from(this).inflate(R.layout.bottom_sheet,null,false)
        val call= view.findViewById<TextView>(R.id.tv_call)
        val message= view.findViewById<TextView>(R.id.tv_message)
        val upload= view.findViewById<TextView>(R.id.tv_upload)

        bottomSheet.apply {
            setContentView(view)
            setCanceledOnTouchOutside(true)
            dismissWithAnimation= true
        }
        call.setOnClickListener {
            shawSnackBar("Call is clicked")
            bottomSheet.dismiss()
        }
        message.setOnClickListener {
            shawSnackBar("Message is clicked")
            bottomSheet.dismiss()
        }
        upload.setOnClickListener {
            shawSnackBar("Upload is clicked")
            bottomSheet.dismiss()
        }


        if(this:: bottomSheet.isInitialized){
            bottomSheet.show()
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