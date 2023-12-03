package com.example.practicanavclase.bombilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import com.example.practicanavclase.R
import com.example.practicanavclase.databinding.ActivityBombillaBinding

class BombillaActivity : AppCompatActivity(), InterruptorBombillaListener{
    private lateinit var binding: ActivityBombillaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBombillaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClickBoton(@IdRes btnId: Int) {
        Log.d("BombillaActivity", "Boton Interruptor pulsado")
        val imgBombillaFragment=supportFragmentManager
            .findFragmentById(R.id.fragmentImagenBombilla) as ImgBombillaFragment
        imgBombillaFragment.actualizaBombilla(btnId)
    }
}