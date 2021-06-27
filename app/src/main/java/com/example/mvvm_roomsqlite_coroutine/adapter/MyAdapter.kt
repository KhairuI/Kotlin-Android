package com.example.mvvm_roomsqlite_coroutine.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_roomsqlite_coroutine.databinding.SingleItemBinding
import com.example.mvvm_roomsqlite_coroutine.model.Item
import com.example.mvvm_roomsqlite_coroutine.ui_view.MainViewModel
import java.util.*
import kotlin.collections.ArrayList

class MyAdapter(var itemList:MutableList<Item>,var searchList:MutableList<Item>, private val viewModel: MainViewModel)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>(),Filterable {

        //private var searchList:MutableList<Item> = itemList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myItem= itemList[position]
        holder.name.text= myItem.name
        holder.amount.text= "${myItem.amount}"
        holder.delete.setOnClickListener {
            viewModel.delete(myItem)
        }
        holder.plus.setOnClickListener {
            myItem.amount++
            viewModel.insert(myItem)
            Log.d("list", "searchList: ${searchList.size}")
        }
        holder.minus.setOnClickListener {
            if(myItem.amount>0){
                myItem.amount--
                viewModel.insert(myItem)
            }
        }
    }

    override fun getItemCount()=itemList.size

    inner class MyViewHolder(private val binding: SingleItemBinding):RecyclerView.ViewHolder(binding.root){

        val name: TextView= binding.singleName
        val amount: TextView= binding.singleAmount
        val delete: ImageView= binding.deleteBtn
        val plus: ImageView= binding.plusBtn
        val minus: ImageView= binding.minusBtn

    }

    override fun getFilter(): Filter {
        return userFilter
    }

    // ****** Filter*****
    private val userFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            //val filterStudent: MutableList<SentMoneyListModel> = ArrayList<SentMoneyListModel>()
            val filterStudent: MutableList<Item> = mutableListOf()

            if (constraint.isEmpty()) {
                filterStudent.addAll(searchList)
            } else {
                val filterPattern = constraint.toString().lowercase().trim()
                for (item in searchList) {
                    if (item.name.lowercase().contains(filterPattern)) {
                        filterStudent.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filterStudent
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            itemList.clear()
            itemList.addAll(results.values as Collection<Item>)
            notifyDataSetChanged()
        }
    }



}