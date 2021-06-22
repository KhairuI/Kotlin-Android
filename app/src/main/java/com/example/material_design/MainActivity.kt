package com.example.material_design

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.material_design.databinding.ActivityMainBinding
import com.example.material_design.databinding.CustomViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.CharSequence as CharSequence1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var openAnim:Animation
    private lateinit var closeAnim:Animation
    private val option= arrayOf("Mango","Banana","Apple","Orange")
    private val select= booleanArrayOf(true,true,false, false)
    val fruiteList = listOf(*option)
    private var result=""
    private  var isVisible= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val option= arrayOf("Mango","Banana","Apple","Orange")
        openAnim= AnimationUtils.loadAnimation(this,R.anim.fab_open)
        closeAnim= AnimationUtils.loadAnimation(this,R.anim.fab_close)

        binding.snackBar.setOnClickListener {

            val snackBar= Snackbar.make(binding.coordinate,"This is Snackbar",Snackbar.LENGTH_LONG)
            // set action
            snackBar.setAction("Undo"
            ) {
                //Snackbar.make(it,"Click Undo",Snackbar.LENGTH_LONG).show()
            }
            //snackBar.duration = 5000
            //snackBar.anchorView= binding.addButton  // -> set snackbar to upper side
            snackBar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
            snackBar.show()
        }
        binding.addButton.setOnClickListener {

        }
        binding.dialogue.setOnClickListener {

            openDialogue()
        }
        binding.customDialogue.setOnClickListener {
          customDialogue()
        }
        binding.dialogue2.setOnClickListener {
            //openDialogue2()
            openDialogue3()
        }
        binding.activity2.setOnClickListener {
            
        }
        binding.contact.setOnClickListener {

            if(isVisible==0){

                binding.contact.rotation= 45F
               // binding.call.visibility= View.VISIBLE
                //binding.message.visibility= View.VISIBLE
                binding.call.startAnimation(openAnim)
                binding.message.startAnimation(openAnim)

                isVisible= 1
            }
            else{
                binding.contact.rotation= 0F
                //binding.call.visibility= View.INVISIBLE
                //binding.message.visibility= View.INVISIBLE
                binding.call.startAnimation(closeAnim)
                binding.message.startAnimation(closeAnim)

                isVisible= 0
            }
        }
    }

    private fun customDialogue(){
        val builder= MaterialAlertDialogBuilder(this)
        builder.setView(R.layout.custom_view)
        builder.background = resources.getDrawable(R.drawable.dialogue_bg,null)
        builder.show()
    }

    private fun openDialogue3(){
        val builder= MaterialAlertDialogBuilder(this)
        builder.setTitle("Choose Multiple Fruite")
        builder.background = resources.getDrawable(R.drawable.dialogue_bg,null)
        builder.setMultiChoiceItems(option,select){ dialogInterface: DialogInterface, which: Int, isChecked: Boolean ->

            select[which]=isChecked // update current check..
            //val selectItem= fruiteList[which]
           // Snackbar.make(binding.rootLayout,"You have select $selectItem",Snackbar.LENGTH_LONG).show()
        }
        builder.setPositiveButton("YES"){ dialogInterface: DialogInterface, i: Int ->

            for(i in select.indices){
                val checked= select[i]
                if(checked){
                    result += "${fruiteList[i]} "
                }
            }
            Snackbar.make(binding.rootLayout,"You have select $result",Snackbar.LENGTH_LONG).show()
            result=""

        }
        builder.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->

        }
        builder.show()
    }

    private fun openDialogue2() {
        val builder= MaterialAlertDialogBuilder(this)
        builder.setTitle("Choose Fruite")
        builder.background = resources.getDrawable(R.drawable.dialogue_bg,null)
        builder.setSingleChoiceItems(option,0) { dialogInterface: DialogInterface, i: Int ->
            val value= option[i]
            Snackbar.make(binding.rootLayout,"You have select $value",Snackbar.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.show()

    }

    private fun openDialogue() {
        val builder= MaterialAlertDialogBuilder(this)
        builder.setTitle("This is Title")
        builder.setMessage("This is simple message")
        builder.setIcon(R.drawable.ic_up)
        builder.background = resources.getDrawable(R.drawable.dialogue_bg,null)
        builder.setPositiveButton("YES"){ dialogInterface: DialogInterface, i: Int ->
            Snackbar.make(binding.rootLayout,"Press Yes",Snackbar.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->

        }
        builder.show()
    }
}

