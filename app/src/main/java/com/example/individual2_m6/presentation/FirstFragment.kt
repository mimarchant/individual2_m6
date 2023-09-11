package com.example.individual2_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.individual2_m6.databinding.FragmentFirstBinding
import androidx.lifecycle.Observer
import com.example.individual2_m6.data.Item


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ViewModel by activityViewModels()
    private lateinit var tvPrecioTotal: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)


        val picker = binding.picker
        val minValue = 1
        val maxValue = 100
        val default = 1
        picker.minValue = minValue
        picker.maxValue = maxValue
        picker.value = default


        tvPrecioTotal = binding.tvTotal
         viewModel.getAllItems().observe(viewLifecycleOwner, Observer<List<Item>>{ item->
            tvPrecioTotal.text = viewModel.calcularTotal(item)
        })


        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.tvIngreso.text.toString()
            val precio = binding.tvPrecio.text.toString().toInt()
            val cantidad = binding.picker.value

            viewModel.insertItem(nombre, precio, cantidad )
        }
    }
}