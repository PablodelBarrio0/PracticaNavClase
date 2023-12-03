package com.example.practicanavclase.semaforo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavclase.databinding.ActivitySemaforoBinding
import com.mpd.pmdm.practicanavegacion1.semaforo.model.Semaforo

class SemaforoActivity : AppCompatActivity(), BotonSemaforoListener {
    private lateinit var binding: ActivitySemaforoBinding
    private val semaforo = Semaforo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySemaforoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState==null){
            val fragmentContainerColorSemaforo = binding.fragmentColorSemaforo
            val semaforoColorFragment = SemaforoColorFragment()
            supportFragmentManager
                .beginTransaction()
                .add(fragmentContainerColorSemaforo.id, semaforoColorFragment)
                .commit()

            val fragmentContainerBtnSemaforo = binding.fragmentBotonSemaforo
            val btnsemaforoFragment = BtnSemaforoFragment()
            supportFragmentManager
                .beginTransaction()
                .add(fragmentContainerBtnSemaforo.id, btnsemaforoFragment)
                .commit()
        }
    }

    override fun onClickButton() {
        semaforo.avanzar()
        val semaforoColorFragment = SemaforoColorFragment.newInstance(semaforo.color)

        val fragmentContainerColorSemaforo = binding.fragmentColorSemaforo
        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainerColorSemaforo.id, semaforoColorFragment)
            .commit()
    }
}