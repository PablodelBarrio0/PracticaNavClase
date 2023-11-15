package com.example.practicanavclase.semaforo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavclase.R
import com.example.practicanavclase.databinding.FragmentBtnBombillaBinding
import com.example.practicanavclase.databinding.FragmentImgBombillaBinding
import com.example.practicanavclase.databinding.FragmentSemaforoColorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val COLOR_SEMAFORO = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [SemaforoColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SemaforoColorFragment : Fragment() {

    private var _binding: FragmentSemaforoColorBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSemaforoColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorSemaforo=arguments?.getInt(COLOR_SEMAFORO, Color.RED)?:0
        actualizarSemaforo(colorSemaforo)
    }

    private fun actualizarSemaforo(colorSemaforo: Int) {
        binding.semaforo.setBackgroundColor(colorSemaforo)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SemaforoColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(color: Int) =
            SemaforoColorFragment().apply {
                arguments = Bundle().apply {
                    putInt(COLOR_SEMAFORO, color)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}