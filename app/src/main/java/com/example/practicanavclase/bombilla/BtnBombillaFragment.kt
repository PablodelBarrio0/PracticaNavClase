package com.example.practicanavclase.bombilla

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practicanavclase.R
import com.example.practicanavclase.databinding.FragmentBtnBombillaBinding


class BtnBombillaFragment : Fragment() {
    private lateinit var observadorInterruptor:InterruptorBombillaListener
    private var _binding: FragmentBtnBombillaBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentBtnBombillaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is InterruptorBombillaListener){
            observadorInterruptor=context
        }
        else{
            throw RuntimeException("$context must implement InterruptorBombillaListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnApagar.setOnClickListener{
            observadorInterruptor.onClickBoton(it.id)
            intercambiarEstadosBotones()
        }

        binding.btnEncender.setOnClickListener{
            boton -> observadorInterruptor.onClickBoton(boton.id)
            intercambiarEstadosBotones()
        }
    }

    private fun intercambiarEstadosBotones() {
        val listaBotones= listOf<Button>(
            binding.btnApagar,
            binding.btnEncender
        )

        listaBotones.forEach{
            it.isEnabled=!it.isEnabled
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}