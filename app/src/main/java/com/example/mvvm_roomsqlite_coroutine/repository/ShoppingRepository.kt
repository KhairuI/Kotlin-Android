package com.example.mvvm_roomsqlite_coroutine.repository

import com.example.mvvm_roomsqlite_coroutine.model.Item
import com.example.mvvm_roomsqlite_coroutine.utils.ShoppingDB

class ShoppingRepository(private val db: ShoppingDB) {



    suspend fun insert(item: Item)= db.shoppingDAO.insert(item)

    suspend fun delete(item: Item)=  db.shoppingDAO.delete(item)

    fun getAllItem()= db.shoppingDAO.getAllItem()
}