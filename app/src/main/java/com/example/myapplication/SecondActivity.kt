package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val percentage = intent.getStringExtra("percentage")
        val sname = intent.getStringExtra("sname")
        val fname = intent.getStringExtra("fname")
        val result = intent.getStringExtra("result")

        binding.tvResult.text = "Совместимость между $fname и $sname: $percentage%. $result"
    }
}
