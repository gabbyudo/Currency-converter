package com.example.currencyconverterapp.model


data class Currency(
    val privacy: String?,
    val quotes: Map<String, Double>?,
    val source: String?,
    val success: Boolean?,
    val timestamp: Long?
)

