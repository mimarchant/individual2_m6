package com.example.individual2_m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.individual2_m6.data.Item
import com.example.individual2_m6.databinding.ItemRecyclerViewBinding

class Adapter: RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    private val listItem = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    fun setData(listaItem:List<Item>){
        this.listItem.clear()
        this.listItem.addAll(listaItem)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    inner class ItemViewHolder(val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvNombreItem.text = item.nombre
            binding.tvPrecioItem.text = "$${item.precio.toString()}"
            binding.tvCantidadItem.text = "Cant. ${item.cantidad.toString()}"
            binding.tvTotal.text = "Total. ${(item.precio * item.cantidad).toString()}"
        }
    }
}