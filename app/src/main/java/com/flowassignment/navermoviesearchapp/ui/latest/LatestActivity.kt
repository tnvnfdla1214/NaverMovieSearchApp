package com.flowassignment.navermoviesearchapp.ui.latest

import android.content.Intent
import android.net.Uri
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.flowassignment.navermoviesearchapp.R
import com.flowassignment.navermoviesearchapp.databinding.ActivityLatestBinding
import com.flowassignment.navermoviesearchapp.databinding.ActivityMainBinding
import com.flowassignment.navermoviesearchapp.ui.base.BaseActivity
import com.flowassignment.navermoviesearchapp.ui.main.MainActivity
import com.flowassignment.navermoviesearchapp.ui.main.MainViewModel
import com.flowassignment.navermoviesearchapp.ui.main.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LatestActivity : BaseActivity<ActivityLatestBinding>(R.layout.activity_latest) {

    private val viewModel by viewModels<LatestViewModel>()

    private lateinit var latestWordAdapter: LatestWordAdapter

    override fun initView() {
        viewModel.getWordList()
        setRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.wordListStateFlow.collectLatest {
                latestWordAdapter.updateList(it)
            }
        }
    }

    private fun setRecyclerView() {
        latestWordAdapter = LatestWordAdapter(
            emptyList()
        ) {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(KEY_WORD, it)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.lateswordtRV.adapter = latestWordAdapter
    }

    companion object {
        const val KEY_WORD = "KEY_WORD"
    }

}