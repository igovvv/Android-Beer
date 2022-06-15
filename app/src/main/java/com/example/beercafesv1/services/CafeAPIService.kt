package com.example.beercafesv1.services

import com.example.beercafesv1.models.BeerCafeItem


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASE_URL =
    "https://opendata.visitflanders.org/tourist/reca/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CafeAPIService{
    @GET("beer_bars.json")
   suspend fun getCafeList(): List<BeerCafeItem>
}

object CafeApi{
    val retrofitService : CafeAPIService by lazy { retrofit.create(CafeAPIService::class.java) }
}