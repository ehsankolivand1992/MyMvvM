package com.chepra.mymvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class BooksViewModel(private val repository: BookRepository)
    : ViewModel() {

    private lateinit var job: Job

    private val _books = MutableLiveData<List<BooksItem>>()
    val books :LiveData<List<BooksItem>>
    get() = _books


     fun getBooks()
    {
        job = Coroutines.ioThenMain({repository.getBooks()} , {
            _books.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }


}