package com.example.retrofitcourse.network

import com.example.retrofitcourse.models.Comment
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface ApiService {

    @GET("comments")
    suspend fun getComments() : Response<List<Comment>>

    companion object{
        operator fun invoke() : ApiService {
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}