package com.chepra.mymvvm

class BookRepository(
    private val api: BookApi
): ApiRequestClass() {
    suspend fun getBooks() = apiRequest { api.getBooks() }
}