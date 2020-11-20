package com.stopkaaaa.exchangerates

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.stopkaaaa.exchangerates.data.model.ExchangeRatesResponse
import com.stopkaaaa.exchangerates.data.net.RetrofitClient
import com.stopkaaaa.exchangerates.databinding.ExchangeLayoutBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var activityBinding: ExchangeLayoutBinding
    private lateinit var retrofitClient: RetrofitClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ExchangeLayoutBinding.inflate(this.layoutInflater)
        setContentView(activityBinding.root)
        retrofitClient = RetrofitClient()

        val baseCurrencySpinnerAdapter: ArrayAdapter<String> =
            ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                resources.getStringArray(R.array.currencies)
            )
        baseCurrencySpinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        activityBinding.baseCurrencySpinner.adapter = baseCurrencySpinnerAdapter
        activityBinding.currency1Spinner.adapter = baseCurrencySpinnerAdapter
        activityBinding.convertButton.setOnClickListener {
            convert(
                activityBinding.moneyEdit.text.toString(),
                activityBinding.baseCurrencySpinner.selectedItem.toString(),
                activityBinding.currency1Spinner.selectedItem.toString()
            )
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun convert(amount: String, baseCurrency: String, targetCurrency: String) {
        retrofitClient.exchangeRatesAPI.convert(targetCurrency, baseCurrency).enqueue(object :
            Callback<ExchangeRatesResponse> {
            override fun onResponse(
                call: Call<ExchangeRatesResponse>,
                response: Response<ExchangeRatesResponse>
            ) {
                val exchangeRates = response.body()
                if (exchangeRates != null) {
                    activityBinding.currency1.text =
                        (amount.toDouble() * (exchangeRates.rates?.get(targetCurrency)
                            ?: error("No exchange rate value"))).toString()
                }
            }

            override fun onFailure(call: Call<ExchangeRatesResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }

//    private fun getRates() {
//        retrofitClient.exchangeRatesAPI.getLatest().enqueue(object :
//            Callback<ExchangeRatesResponse> {
//            override fun onResponse(
//                call: Call<ExchangeRatesResponse>,
//                response: Response<ExchangeRatesResponse>
//            ) {
//                val exchangeRates = response.body()
//                if (exchangeRates != null) {
//                    binding.currency1.text = exchangeRates.base
//                    binding.currency2.text = exchangeRates.rates?.usd.toString()
//                    binding.currency3.text = exchangeRates.rates?.rub.toString()
//                    binding.currency4.text = exchangeRates.rates?.cad.toString()
//                    binding.currency5.text = exchangeRates.rates?.thb.toString()
//                    binding.currency6.text = exchangeRates.date.toString()
//                }
//            }
//
//            override fun onFailure(call: Call<ExchangeRatesResponse>, t: Throwable) {
//                Toast.makeText(applicationContext , t.toString(), Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
}