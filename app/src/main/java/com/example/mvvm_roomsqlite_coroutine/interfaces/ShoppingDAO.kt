package com.example.mvvm_roomsqlite_coroutine.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm_roomsqlite_coroutine.model.Item

@Dao
interface ShoppingDAO {

    // for insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item):Long

    // for delete...
    @Delete
    suspend fun delete(item: Item):Int

    // get all student
    @Query("SELECT * FROM shopping_table")
    fun getAllItem(): LiveData<MutableList<Item>>

}