package com.turicticapp.dccomic.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object WebService {
    private const val urlApi = "https://my-json-server.typicode.com/"

    private val okkHtppClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit: ApiService = Retrofit.Builder()
        .baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkHtppClient)
        .build()
        .run {
            create(ApiService::class.java)
        }


}