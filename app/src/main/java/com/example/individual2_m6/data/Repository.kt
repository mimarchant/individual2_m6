package com.example.individual2_m6.data

import androidx.lifecycle.LiveData

class Repository(private val itemDao:Dao) {
    suspend fun  insertItem(item:Item){
        itemDao.insertItem(item)
    }

    fun getItem():
            LiveData<List<Item>> {
        return itemDao.getAllItems()
    }
}