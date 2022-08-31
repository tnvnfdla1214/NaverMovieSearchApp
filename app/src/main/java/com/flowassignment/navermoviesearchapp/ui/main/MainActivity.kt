package com.flowassignment.navermoviesearchapp.ui.main

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.flowassignment.navermoviesearchapp.R
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.flowassignment.navermoviesearchapp.databinding.ActivityMainBinding
import com.flowassignment.navermoviesearchapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var movieAdapter: MovieAdapter

    override fun initView() {
        setRecyclerView()
        observeViewModel()
        setClickListener()
    }

    private fun setClickListener() {
        binding.searchButton.setOnClickListener {
            val keyword = binding.searchEditText.text.toString()
            viewModel.getMovieList(keyword)
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.movieListStateFlow.collectLatest {
                movieAdapter.updateList(it)
            }
        }
    }

    private fun setRecyclerView() {
        movieAdapter = MovieAdapter(
            emptyList()
        ) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.link))
            startActivity(intent)
        }
        binding.searchRV.adapter = movieAdapter
    }

}