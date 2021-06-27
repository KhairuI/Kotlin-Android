package com.example.mvvm_roomsqlite_coroutine.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class Item (
    @ColumnInfo(name = "item_name")
    val name:String,
    @ColumnInfo(name = "item_amount")
    var amount:Int
    ){
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null
}