package com.example.individual2_m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.individual2_m6.data.DataBase
import com.example.individual2_m6.data.Item
import com.example.individual2_m6.data.Repository
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repository

    init {
        val dao = DataBase.getDatabase(application).getItemDao()
        repositorio = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repositorio.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item( nombre, precio, cantidad)
        repositorio.insertItem(item)
    }
    fun calcularTotal(item: List<Item>):String{
        var precioTotal = 0
        for (item in item) {
            precioTotal += item.precio * item.cantidad
        }
        return precioTotal.toString()
    }
}