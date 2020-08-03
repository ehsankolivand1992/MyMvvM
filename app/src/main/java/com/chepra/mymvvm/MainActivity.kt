package com.chepra.mymvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = BookRepository(BookApi())
        GlobalScope.launch(Dispatchers.Main) {
            val books = repository.getBooks()
            Toast.makeText(applicationContext,books[0].name,Toast.LENGTH_LONG).show()
        }
    }
}