package com.flowassignment.navermoviesearchapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flowassignment.navermoviesearchapp.R
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flowassignment.navermoviesearchapp.databinding.ActivityMainBinding
import com.flowassignment.navermoviesearchapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun initView() {
        viewModel.getMovieList()
    }
}