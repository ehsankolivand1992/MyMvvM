package com.chepra.mymvvm


import com.google.gson.annotations.SerializedName

data class BooksItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Int,

    @SerializedName("updated_at")
    val updatedAt: String
)