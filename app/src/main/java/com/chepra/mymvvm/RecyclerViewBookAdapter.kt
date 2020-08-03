package com.chepra.mymvvm

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chepra.mymvvm.databinding.RcvItemBinding

class RecyclerViewBookAdapter(
    private val  listOfBooks : List<BooksItem>
) : RecyclerView.Adapter<RecyclerViewBookAdapter.BooksViewHolder>() {

inner class BooksViewHolder(
    val rcvItemBinding: RcvItemBinding
): RecyclerView.ViewHolder(rcvItemBinding.root)


    override fun getItemCount() = listOfBooks.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BooksViewHolder(
        DataBindingUtil.inflate<RcvItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rcv_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.rcvItemBinding.book = listOfBooks[position]
    }
}