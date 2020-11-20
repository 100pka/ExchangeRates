package com.stopkaaaa.exchangerates.data.net

import com.stopkaaaa.exchangerates.data.model.ExchangeRatesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRatesAPI {
    @GET("latest/")
    fun getLatest(): Call<ExchangeRatesResponse>

    @GET("latest/")
    fun convert(@Query("symbols") target: String, @Query("base") base: String): Call<ExchangeRatesResponse>
}