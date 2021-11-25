package com.dicoding.latihan_android_architecture_component_1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Setup variable
    var result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}