package com.chepra.mymvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadimage")
fun loadImage(view : ImageView, url: String)
{
    val finalUrl = "http://chepra.com/mvvmbooks/storage/app/public/$url"
    Glide.with(view)
        .load(finalUrl)
        .into(view)

}