package com.example.mvvm_roomsqlite_coroutine.ui_view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_roomsqlite_coroutine.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: ShoppingRepository)
    :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}