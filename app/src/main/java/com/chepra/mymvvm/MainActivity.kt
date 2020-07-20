package com.chepra.mymvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking {
            launch {
                delay(1000L)
                Toast.makeText(applicationContext,"it's okey",Toast.LENGTH_LONG).show() }
        }
    }
}