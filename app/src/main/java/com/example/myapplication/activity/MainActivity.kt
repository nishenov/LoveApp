package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MVVM.LoveViewModel
import com.example.myapplication.MVVM.LoveViewModelFactory
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.App

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: LoveViewModel by viewModels {
        LoveViewModelFactory((application as App).api)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.loveResult.observe(this, { loveResult ->
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("percentage", loveResult.percentage)
                putExtra("fname", loveResult.fname)
                putExtra("sname", loveResult.sname)
                putExtra("result", loveResult.result)
            }
            startActivity(intent)
        })

        viewModel.error.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        binding.btnResult.setOnClickListener {
            viewModel.getLovePercentage(
                key = "5ca609edcemsh37fb5858eaaf930p1c12bejsnfc6d9b8ad6ab",
                host = "love-calculator.p.rapidapi.com",
                firstName = binding.etFirstName.text.toString(),
                secondName = binding.etSecondName.text.toString()
            )
        }
    }
}
