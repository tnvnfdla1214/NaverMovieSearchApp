package com.flowassignment.navermoviesearchapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.usecase.GetSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSearchListUseCase: GetSearchListUseCase
) : ViewModel() {

    fun getMovieList() {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = getSearchListUseCase("혹성탈출")) {
                is DataResult.Success -> {
                    Log.d("민규",result.data.toString())
                }
                is DataResult.NoData -> {
                    Log.d("민규","NoData")
                }
                is DataResult.Error -> {
                    Log.d("민규","에러")
                }
            }
        }
    }
}