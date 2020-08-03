package com.chepra.mymvvm

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookApi {

    @GET("book")
    suspend fun getBooks():Response<List<BooksItem>>

    companion object {
        operator fun invoke():BookApi
        {
          return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://chepra.com/mvvmbooks/public/api/")
                .build()
                .create(BookApi::class.java)
        }
    }
}