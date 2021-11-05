package com.example.retrofitcourse

data class Comment(
    val id: Int? = null,
    val postId: Int? = null,
    val name: String,
    val email:String,
    val body: String
)
