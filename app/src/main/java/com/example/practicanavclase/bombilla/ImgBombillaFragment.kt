package com.example.practicanavclase.bombilla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavclase.R
import com.example.practicanavclase.bombilla.model.Bombilla
import com.example.practicanavclase.databinding.FragmentImgBombillaBinding

class ImgBombillaFragment : Fragment() {

    private var _binding : FragmentImgBombillaBinding?=null
    private val binding get()=_binding!!
    private lateinit var bombilla : Bombilla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bombilla=Bombilla()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentImgBombillaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        actualizarImgBombilla()
    }

    fun actualizaBombilla(btnId: Int) {
        if(btnId==R.id.btnEncender){
            bombilla.encender()
        }else{
            bombilla.apagar()
        }
        actualizarImgBombilla()
    }

    private fun actualizarImgBombilla() {
        if(bombilla.estaEncendida()){
            binding.imgBombilla.setImageResource(R.drawable.encendida)
        }
        else{
            binding.imgBombilla.setImageResource(R.drawable.apagada)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}