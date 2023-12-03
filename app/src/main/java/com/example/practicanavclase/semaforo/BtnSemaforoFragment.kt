package com.example.practicanavclase.semaforo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practicanavclase.R
import com.example.practicanavclase.databinding.FragmentBtnSemaforoBinding


class BtnSemaforoFragment : Fragment() {
    private lateinit var observadorBtnSemaforo: BotonSemaforoListener

    private var _binding: FragmentBtnSemaforoBinding?=null
    private val binding get()=_binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity is BotonSemaforoListener){
            observadorBtnSemaforo=activity as BotonSemaforoListener
        }
        else{
            throw RuntimeException("$context must implements BotonSemaforoListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentBtnSemaforoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSemaforo = view.findViewById<Button>(R.id.btnSemaforo)
        btnSemaforo.setOnClickListener{
            observadorBtnSemaforo.onClickButton()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}