package com.example.currencyconverterapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverterapp.model.Currency
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.round

class MainViewModel : ViewModel() {
    private val repository = CurrencyRepository()

    private val _myCurrency = MutableLiveData<Currency>()
    val myCurrency: LiveData<Currency>
        get() = _myCurrency

    private val _myCurrencyList = MutableLiveData<List<String>>()
    val myCurrencyList: LiveData<List<String>>
        get() = _myCurrencyList

   /*fun getRates() {
        CoroutineScope(Dispatchers.IO).launch {
            _myCurrency.value = repository.getRates()
        }
    }*/
    fun getCurrencies(){
        val rates =  repository.getCurrencyRates().keys
       _myCurrencyList.value = rates.toList()
    }

    fun convert(amount: String, fromCurrency: String, toCurrency: String) {
        if (amount.isEmpty()) {
            return
        } else if(repository.getCurrencyRates().keys.contains("USD$fromCurrency")){
            val input = amount.toDouble()
            val toResult = "USD$toCurrency".toDouble()
            val fromInput = "USD$fromCurrency".toDouble()
            val initialConversion = round(input * fromInput)
            val finalConversion = round(initialConversion * toResult)


        }

      /*if (amount.isEmpty()) {
          return
      } else {
          val input = amount.toDouble()
          val toResult = toCurrency

        //  val baseConverter = round((base * input)/to)
       // _myCurrency.value = baseConverter*/


}
}
