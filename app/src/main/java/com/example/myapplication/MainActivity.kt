package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoveView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter(this, (application as App).api)

        binding.btnResult.setOnClickListener {
            presenter.getLovePercentage(
                key = "5ca609edcemsh37fb5858eaaf930p1c12bejsnfc6d9b8ad6ab",
                host = "love-calculator.p.rapidapi.com",
                firstName = binding.etFirstName.text.toString(),
                secondName = binding.etSecondName.text.toString()
            )
        }
    }

    override fun showResult(loveResult: LoveResult) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("percentage", loveResult.percentage)
            putExtra("fname", loveResult.fname)
            putExtra("sname", loveResult.sname)
            putExtra("result", loveResult.result)
        }
        startActivity(intent)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
