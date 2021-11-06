package com.example.retrofitcourse.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitcourse.network.CommentRepository

@Suppress("UNCHECK_CAST")
class CommentViewModelFactory(
    private val repository: CommentRepository
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentViewModel(repository) as T
    }
}