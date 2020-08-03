package com.chepra.mymvvm

import kotlinx.coroutines.*
import javax.security.auth.callback.Callback

object Coroutines  {


    fun <T : Any> ioThenMain(work: suspend (()-> T?),callback: ((T?) -> Unit )) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }

}