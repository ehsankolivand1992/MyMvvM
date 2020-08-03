package com.chepra.mymvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BooksViewModelFactory(
    private val repository: BookRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BooksViewModel(repository) as T
    }

}