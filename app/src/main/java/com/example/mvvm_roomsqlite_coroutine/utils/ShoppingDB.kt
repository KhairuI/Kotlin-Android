package com.example.mvvm_roomsqlite_coroutine.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_roomsqlite_coroutine.interfaces.ShoppingDAO
import com.example.mvvm_roomsqlite_coroutine.model.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ShoppingDB:RoomDatabase() {
    abstract val shoppingDAO: ShoppingDAO


    companion object{
        @Volatile
        private var instance:ShoppingDB?=null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDB(
                        context
                    ).also { instance = it }
            }

        private fun createDB(context: Context)= Room.databaseBuilder(context.applicationContext,
            ShoppingDB::class.java,"shopping_db").build()

    }
}