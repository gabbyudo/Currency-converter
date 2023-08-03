package com.example.currencyconverterapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverterapp.model.Currency
import kotlin.math.round

class MainViewModel : ViewModel() {
    private val repository = CurrencyRepository()

    private val _myCurrency = MutableLiveData<Currency>()
    val myCurrency: LiveData<Currency>
        get() = _myCurrency

    private val _myCurrencyList = MutableLiveData<List<String>>()
    val myCurrencyList: LiveData<List<String>>
        get() = _myCurrencyList

    private val _showResult = MutableLiveData<Double>()
    val showResult: LiveData<Double>
        get() = _showResult

   /*fun getRates() {
        CoroutineScope(Dispatchers.IO).launch {
            _myCurrency.value = repository.getRates()
        }
    }*/
    fun getCurrencies(){
        val realRates =  repository.getCurrencyRates().keys
       val rates = realRates.map {
           it.substring(3,6)
       }
       _myCurrencyList.value = rates.toList()
    }
    val mySource = repository.getCurrencyRates()

    fun convert(amount: String, fromCurrency: String, toCurrency: String) {
        if (amount.isEmpty()) {
            return
        } else if(mySource.keys.contains("USD$fromCurrency")&&
                mySource.keys.contains("USD$toCurrency")){
            val input = amount.toDouble()
            val toResult = mySource["USD$toCurrency"]
            val fromInput = mySource["USD$fromCurrency"]
            val initialConversion = round(input * fromInput!!)
            val finalConversion = round(initialConversion * toResult!!)
            _showResult.value = finalConversion
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
