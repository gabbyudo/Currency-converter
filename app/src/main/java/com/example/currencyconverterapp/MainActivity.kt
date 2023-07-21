package com.example.currencyconverterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencyconverterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.convertButton.setOnClickListener{
            Log.e("tagz", "hg")
            viewModel.convert(
                source = 4.0, binding.inputField.text.toString(),
                toCurrency = 2.0
            )
            Log.e("tagz", "mnnm")
        }
        viewModel.myCurrency.observe(this, Observer {
            Log.e("sd", "yu")
            binding.showResult.text = it.toString()
            Log.e("gf", "lo")
        })
        viewModel.convert( source = 4.0, binding.inputField.text.toString(),
            toCurrency = 2.0)
    }
}