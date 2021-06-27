package com.example.mvvm_roomsqlite_coroutine.ui_view

import androidx.lifecycle.ViewModel
import com.example.mvvm_roomsqlite_coroutine.model.Item
import com.example.mvvm_roomsqlite_coroutine.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ShoppingRepository):ViewModel() {

    fun insert(item: Item)= CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: Item)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItem()= repository.getAllItem()
}