package com.example.currencyconverterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                if (binding.spinnerFrom == null){
            viewModel.convert(
                binding.inputField.text.toString(),
                binding.spinnerFrom.selectedItem.toString(),
                binding.spinnerTo.selectedItem.toString()
            )}
        }
        viewModel.myCurrencyList.observe(this, Observer {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, it)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerFrom.adapter = adapter

            binding.spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(

                    parent: AdapterView<*>?,

                    view: View?,

                    position: Int,

                    id: Long

                ) {
                    binding.from.text = it[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }

        })
        viewModel.getCurrencies()

        viewModel.myCurrencyList.observe(this, Observer {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, it)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTo.adapter = adapter

            binding.spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(

                    parent: AdapterView<*>?,

                    view: View?,

                    position: Int,

                    id: Long

                ) {
                     binding.to.text = it[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }

        })
        viewModel.getCurrencies()

        viewModel.myCurrencyList.observe(this, Observer {
            //binding.showResult.text = it.toString()

        })
       /* viewModel.convert( binding.inputField.text.toString(), fromCurrency = "",
            toCurrency = 2.0)*/
    }
}