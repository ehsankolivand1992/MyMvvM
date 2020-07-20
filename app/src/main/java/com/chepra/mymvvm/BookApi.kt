package com.chepra.mymvvm

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookApi {

    @GET("books")
    suspend fun getBooks():Response<List<Book>>

    companion object {
        operator fun invoke():BookApi
        {
          return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("www.chepra.com")
                .build()
                .create(BookApi::class.java)
        }
    }
}