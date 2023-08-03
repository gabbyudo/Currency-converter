package com.example.currencyconverterapp

import android.util.Log
import com.example.currencyconverterapp.model.Currency

class CurrencyRepository {
    /*suspend fun getRates(): Currency {
        return CurrencyApi.retrofitService.getRates()
    }*/

    fun getCurrencyRates(): Map<String, Double> {
        val rates = mapOf<String, Double>(
            "USDAED" to 3.672982,
            "USDAFN" to 57.8936,
            "USDALL" to 126.1652,
            "USDAMD" to 475.306,
            "USDANG" to 1.78952,
            "USDNGN" to 750.000,
            "USDGBP" to 1.2100
        )
        return rates
    }
}