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
    //private val repository = CurrencyRepository()

    private val _myCurrency = MutableLiveData<Double>()
    val myCurrency: LiveData<Double>
        get() = _myCurrency

   /* fun getRates() {
        CoroutineScope(Dispatchers.IO).launch {
            _myCurrency.value = repository.getRates()
        }
    }*/
    fun convert(source: Double,amount: String, toCurrency: Double){
       Log.e("tagz", "ok $amount")
      if (amount.isEmpty()) {
          return
      } else {
       val base = source
       val to = toCurrency
       val input = amount.toDouble()
       Log.e("tagz", "mhg")
        val baseConverter = round((base * input)/to)
       Log.e("tagz", "klm $baseConverter")
        _myCurrency.value = baseConverter
       Log.e("tagz", "plo")
      }
    }
}
