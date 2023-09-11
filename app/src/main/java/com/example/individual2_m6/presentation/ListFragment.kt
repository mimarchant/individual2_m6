package com.example.individual2_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.individual2_m6.R
import com.example.individual2_m6.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    val itemViewModel: ViewModel by activityViewModels()
    val adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_firstFragment)
        }

        initLista()

        return binding.root
    }

    private fun initLista() {
        itemViewModel.getAllItems().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

        binding.recycler.adapter = adapter
    }
}