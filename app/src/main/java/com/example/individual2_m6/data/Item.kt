package com.example.individual2_m6.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_item")
data class Item(val nombre:String,val precio:Int, val cantidad:Int){
    @PrimaryKey(autoGenerate = true) var id:Long = 0
}