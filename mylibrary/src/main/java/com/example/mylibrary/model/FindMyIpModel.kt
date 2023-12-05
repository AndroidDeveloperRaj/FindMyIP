package com.example.mylibrary.model

import com.google.gson.annotations.SerializedName

data class FindMyIpModel(
        @SerializedName("ip")
        val ip: String,
        @SerializedName("network")
        val network: String,
        @SerializedName("version")
        val version: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("region")
        val region: String,
        @SerializedName("region_code")
        val regionCode: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("country_name")
        val countryName: String,
        @SerializedName("country_code")
        val countryCode: String,
        @SerializedName("country_code_iso3")
        val countryCodeIso3: String,
        @SerializedName("country_capital")
        val countryCapital: String,
        @SerializedName("country_tld")
        val countryTld: String,
        @SerializedName("continent_code")
        val continentCode: String,
        @SerializedName("in_eu")
        val inEu: Boolean,
        @SerializedName("postal")
        val postal: String,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("longitude")
        val longitude: Double,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("utc_offset")
        val utcOffset: String,
        @SerializedName("country_calling_code")
        val countryCallingCode: String,
        @SerializedName("currency")
        val currency: String,
        @SerializedName("currency_name")
        val currencyName: String,
        @SerializedName("languages")
        val languages: String,
        @SerializedName("country_area")
        val countryArea: Double,
        @SerializedName("country_population")
        val countryPopulation: Int,
        @SerializedName("asn")
        val asn: String,
        @SerializedName("org")
        val org: String,
)