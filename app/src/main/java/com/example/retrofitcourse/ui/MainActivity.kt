package com.example.retrofitcourse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitcourse.network.ApiService
import com.example.retrofitcourse.R
import com.example.retrofitcourse.databinding.ActivityMainBinding
import com.example.retrofitcourse.models.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.refreshLayout.setOnRefreshListener {
            refreshComment()
        }

        refreshComment()
    }

    private fun refreshComment(){
        binding.refreshLayout.isRefreshing = true
        ApiService().getPhotos().enqueue(object: Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {

                binding.refreshLayout.isRefreshing = false

                val photos = response.body()

                photos?.let {
                    showPhoto(it)
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                binding.refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showPhoto(photos: List<Comment>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = PhotoAdapter(photos)
    }
}