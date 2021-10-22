package com.example.textrecycle

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.textrecycle.databinding.ItemRowBinding

class MyAdapter(private val listener:OnCardClickListener) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var modelList= mutableListOf<ModelClass>()
    private var isChecked= false
    private var lastChecked=-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view= ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model= modelList[position]
        holder.apply {

           title.text= model.name
            price.text= model.price
            if(isChecked){
                radio.isChecked= model.isSelect
            }
            else{
                if(adapterPosition==0){
                    radio.isChecked= true
                    lastChecked=0
                }
            }
            layout.setOnClickListener {
                handleButtonChecked(adapterPosition)
                listener.onCardClick(position,model.name)
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun handleButtonChecked(adapterPosition: Int) {
        isChecked= true
        modelList[lastChecked].isSelect= false
        modelList[adapterPosition].isSelect= true
        lastChecked= adapterPosition
        notifyDataSetChanged()
    }

    override fun getItemCount()= modelList.size


    fun addAll(elements:MutableList<ModelClass>,notify: Boolean){
        modelList.addAll(elements)
        if(notify) notifyDataSetChanged()
    }


    inner class MyViewHolder(binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root){
        val title: TextView = binding.name
        val price:TextView= binding.price
        val layout: ConstraintLayout = binding.layout
        val radio:RadioButton= binding.btnRadio

    }

    interface OnCardClickListener {
        fun onCardClick(position:Int, name:String)
    }



}