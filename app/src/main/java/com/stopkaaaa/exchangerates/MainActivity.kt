package com.stopkaaaa.exchangerates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.stopkaaaa.exchangerates.data.model.ExchangeRatesResponse
import com.stopkaaaa.exchangerates.data.net.RetrofitClient
import com.stopkaaaa.exchangerates.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitClient: RetrofitClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitClient = RetrofitClient()
        binding.currency1.text = "USD"
        binding.getRates.setOnClickListener(View.OnClickListener { getRates() })

    }

    private fun getRates() {
        retrofitClient.exchangeRatesAPI.getLatest().enqueue(object :
            Callback<ExchangeRatesResponse> {
            override fun onResponse(
                call: Call<ExchangeRatesResponse>,
                response: Response<ExchangeRatesResponse>
            ) {
                val exchangeRates = response.body()
                if (exchangeRates != null) {
                    binding.currency1.text = exchangeRates.base
                    binding.currency2.text = exchangeRates.rates?.usd.toString()
                    binding.currency3.text = exchangeRates.rates?.rub.toString()
                    binding.currency4.text = exchangeRates.rates?.cad.toString()
                    binding.currency5.text = exchangeRates.rates?.thb.toString()
                    binding.currency6.text = exchangeRates.date.toString()
                }
            }

            override fun onFailure(call: Call<ExchangeRatesResponse>, t: Throwable) {
                Toast.makeText(applicationContext , t.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}