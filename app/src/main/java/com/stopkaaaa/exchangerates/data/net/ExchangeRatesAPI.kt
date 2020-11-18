package com.stopkaaaa.exchangerates.data.net

import com.stopkaaaa.exchangerates.data.model.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ExchangeRatesAPI {
    @GET("latest/")
    fun getLatest(): Call<ExchangeRatesResponse>
}