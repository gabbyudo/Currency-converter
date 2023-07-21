package com.example.currencyconverterapp.model


data class Currency(
    val privacy: String,
    val quotes: Quotes,
    val source: String,
    val success: Boolean,
    val timestamp: Long
)
class Quotes{
    var rates = listOf<ConversionRate>()
}
data class ConversionRate(val code: String, val rate: Double)

//baseurl