package com.chepra.mymvvm

import retrofit2.Response
import java.io.IOException

abstract class ApiRequestClass {
    suspend fun <T: Any> apiRequest(call: suspend () ->Response<T>) : T{
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        }else {
            throw  ApiException("the error code is ${response.code()}")
        }
    }
}
class ApiException(messageString: String): IOException(messageString)