package com.stopkaaaa.exchangerates.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class ExchangeRatesResponse {

    @SerializedName("rates")
    var rates: ExchangeRates? = null

    @SerializedName("date")
    var date: Date? = null

    @SerializedName("base")
    var base: String? = null

}