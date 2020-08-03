package com.chepra.mymvvm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.books_fragment.*

class BooksFragment : Fragment() {


    private lateinit var viewModel: BooksViewModel
    private lateinit var bookFactory: BooksViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.books_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bookApi = BookApi()
        val repository = BookRepository(bookApi)
        bookFactory = BooksViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,bookFactory).get(BooksViewModel::class.java)

        viewModel.getBooks()
        viewModel.books.observe(viewLifecycleOwner, Observer { books -> rc_books.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = RecyclerViewBookAdapter(books)
        } })


    }

}