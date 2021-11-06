package com.example.retrofitcourse.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitcourse.R
import com.example.retrofitcourse.databinding.CommentsFragmentBinding
import com.example.retrofitcourse.network.ApiService
import com.example.retrofitcourse.network.CommentRepository

class CommentFragment : Fragment() {

    private lateinit var factory: CommentViewModelFactory
    private lateinit var viewModel: CommentViewModel
    private lateinit var binding: CommentsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CommentsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val repository = CommentRepository(ApiService())
        factory = CommentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[CommentViewModel::class.java]
        viewModel.comments.observe(viewLifecycleOwner, Observer { comments ->
            binding.recyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = CommentAdapter(comments)
            }
        })

    }

}