package com.example.practicanavclase.bombilla

import androidx.annotation.IdRes

interface InterruptorBombillaListener {
    fun onClickBoton(@IdRes btnId: Int)
}