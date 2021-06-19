package com.example.kotlin_multi_recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.kotlin_multi_recycle.databinding.View1Binding
import com.example.kotlin_multi_recycle.databinding.View2Binding
import com.example.kotlin_multi_recycle.databinding.View3Binding
import com.example.kotlin_multi_recycle.databinding.View4Binding

// declair
private const val myMessage=0
private const val myImage=1
private const val partnerMessage=2
private const val partnerImage=3


class MyAdapter(val myList: MutableList<String>): Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            myMessage -> {
                val view= View1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return myMessageHolder(view)
            }
            myImage -> {
                val view= View2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return myImageHolder(view)
            }
            partnerMessage -> {
                val view= View3Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return partnerMessageHolder(view)
            }
            else -> {
                val view= View4Binding.inflate(LayoutInflater.from(parent.context),parent,false)
                return partnerImageHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position)== myMessage){
            (holder as myMessageHolder).myName.text=(myList[position])
        }
        else if(getItemViewType(position)== myImage){
            //
        }
        else if(getItemViewType(position)== partnerMessage){
            (holder as partnerMessageHolder).partnerName.text= (myList[position])
        }
        else{
            //(holder as partnerImageHolder).bind(myList[position])
        }
    }

    override fun getItemCount()= myList.size

    override fun getItemViewType(position: Int): Int {
        return if(myList[position]=="uzzal"){
            myMessage
        } else if(myList[position]=="uzzal_image"){
            myImage
        } else if(myList[position]=="partner"){
            partnerMessage
        }
        else{
            partnerImage
        }
    }

    // view holder 1
    class myMessageHolder(binding: View1Binding):RecyclerView.ViewHolder(binding.root){
       val myName:TextView= binding.myMessageId
    }
    // view holder 2
    class myImageHolder(binding: View2Binding):RecyclerView.ViewHolder(binding.root){
        val myImage:ImageView= binding.myImage
    }
    // view holder 3
    class partnerMessageHolder(binding: View3Binding):RecyclerView.ViewHolder(binding.root){
        val partnerName:TextView= binding.partnerMessage

    }
    // view holder 4
    class partnerImageHolder(binding: View4Binding):RecyclerView.ViewHolder(binding.root){

        val partnerImage:ImageView= binding.partnerImage
    }



}