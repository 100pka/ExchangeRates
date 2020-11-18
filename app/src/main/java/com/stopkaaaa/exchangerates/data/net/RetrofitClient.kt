package com.stopkaaaa.exchangerates.data.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val exchangeRatesAPI: ExchangeRatesAPI

    companion object {
        private const val BASE_URL = "https://api.exchangeratesapi.io/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        exchangeRatesAPI = retrofit.create(ExchangeRatesAPI::class.java)
    }

}