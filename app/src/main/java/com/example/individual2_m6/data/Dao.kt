package com.example.individual2_m6.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    suspend fun insertItem(item:Item)

    @Query("SELECT*FROM table_item order by id ASC")
    fun getAllItems(): LiveData<List<Item>>

}