package com.example.retrofitcourse.network

class CommentRepository(private val api : ApiService): SafeApiRequest() {

    suspend fun getComments() = ApiRequest { api.getComments() }
}