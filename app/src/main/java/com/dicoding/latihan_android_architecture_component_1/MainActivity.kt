package com.dicoding.latihan_android_architecture_component_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.dicoding.latihan_android_architecture_component_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Setup variable
    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() /* by: activity-ktx */
    // private lateinit var viewModel: MainViewModel /* by: native */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // viewModel = ViewModelProvider(this)[MainViewModel::class.java] /* by: native */
        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener {
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()
            when {
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Masih kosong"
                }

                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Masih kosong"
                }

                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Masih kosong"
                }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}