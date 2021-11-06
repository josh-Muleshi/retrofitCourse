package com.example.retrofitcourse.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitcourse.models.Comment
import com.example.retrofitcourse.network.CommentRepository
import kotlinx.coroutines.Job

class CommentViewModel(
    private val repository: CommentRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _comments = MutableLiveData<List<Comment>>()
    val comments : LiveData<List<Comment>>
        get() = _comments

    suspend fun getComments(){
        job = Coroutines.ioThenMain(
            { repository.getComments() },
            { _comments.value = it }
        )
    }
}