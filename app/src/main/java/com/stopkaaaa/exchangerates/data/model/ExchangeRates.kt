package com.stopkaaaa.exchangerates.data.model

import com.google.gson.annotations.SerializedName

data class ExchangeRates(
    @SerializedName("CAD")
    var cad : Double,
    @SerializedName("HKD")
    var hkd : Double,
    @SerializedName("ISK")
    var isk : Double,
    @SerializedName("PHP")
    var php : Double,
    @SerializedName("DKK")
    var dkk : Double,
    @SerializedName("HUF")
    var huf : Double,
    @SerializedName("CZK")
    var czk : Double,
    @SerializedName("AUD")
    var aud : Double,
    @SerializedName("RON")
    var ron : Double,
    @SerializedName("SEK")
    var sek : Double,
    @SerializedName("IDR")
    var tdr : Double,
    @SerializedName("INR")
    var tnr : Double,
    @SerializedName("BRL")
    var brl : Double,
    @SerializedName("RUB")
    var rub : Double,
    @SerializedName("HRK")
    var hrk : Double,
    @SerializedName("JPY")
    var jpy : Double,
    @SerializedName("THB")
    var thb : Double,
    @SerializedName("CHF")
    var chf : Double,
    @SerializedName("SGD")
    var sgd : Double,
    @SerializedName("PLN")
    var pln : Double,
    @SerializedName("BGN")
    var bgn : Double,
    @SerializedName("TRY")
    var turkish : Double,
    @SerializedName("CNY")
    var cny : Double,
    @SerializedName("NZD")
    var nzd : Double,
    @SerializedName("NOK")
    var nok : Double,
    @SerializedName("ZAR")
    var zar : Double,
    @SerializedName("USD")
    var usd : Double,
    @SerializedName("MXN")
    var mxn : Double,
    @SerializedName("ILS")
    var ils : Double,
    @SerializedName("GBP")
    var gbp : Double,
    @SerializedName("KRW")
    var krw : Double,
    @SerializedName("MYR")
    var myr : Double
)