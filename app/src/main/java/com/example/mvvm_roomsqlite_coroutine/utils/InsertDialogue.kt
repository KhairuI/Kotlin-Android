package com.example.mvvm_roomsqlite_coroutine.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.example.mvvm_roomsqlite_coroutine.R
import com.example.mvvm_roomsqlite_coroutine.interfaces.AddInterface
import com.example.mvvm_roomsqlite_coroutine.databinding.InsertDialogueBinding
import com.example.mvvm_roomsqlite_coroutine.model.Item

class InsertDialogue(private var addDialogListener: AddInterface):DialogFragment() {

    private lateinit var binding: InsertDialogueBinding
    private val myBinding get() = binding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding= InsertDialogueBinding.inflate(LayoutInflater.from(context))

        val dialog = activity?.let {
            Dialog(it)
        }

        if(dialog != null){

            dialog.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
            dialog.setContentView(myBinding.root)

            myBinding.addBtn.setOnClickListener {
                val name= myBinding.itemEditText.text.toString()
                val amount= myBinding.amountEditText.text.toString()
                if(name.isNotEmpty() && amount.isNotEmpty()){
                    val item= Item(name,amount.toInt())
                    addDialogListener.onAddButtonClicked(item)
                    dismiss()

                }
                else{
                    Toast.makeText(context,"Enter all field",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            myBinding.cancleBtn.setOnClickListener {
                dismiss()
            }

            return dialog
        }


        return super.onCreateDialog(savedInstanceState)
    }
   /*private lateinit var binding: InsertDialogueBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = InsertDialogueBinding.inflate(LayoutInflater.from(context))
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)


        binding.addBtn.setOnClickListener {
            val name= binding.itemEditText.text.toString()
            val amount= binding.amountEditText.text.toString()
            if(name.isNotEmpty() && amount.isNotEmpty()){

                val item= Item(name,amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()

            }
            else{
                Toast.makeText(context,"Enter all field",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        binding.cancleBtn.setOnClickListener {
            dismiss()
        }
    }*/
}


