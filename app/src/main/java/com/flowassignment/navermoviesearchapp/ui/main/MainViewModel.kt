package com.flowassignment.navermoviesearchapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie
import com.flowassignment.navermoviesearchapp.domain.usecase.GetSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSearchListUseCase: GetSearchListUseCase
) : ViewModel() {

    private val _movieListStateFlow: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val movieListStateFlow: StateFlow<List<Movie>> = _movieListStateFlow.asStateFlow()

    fun getMovieList(keyword: String) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = getSearchListUseCase(keyword)) {
                is DataResult.Success -> {
                    _movieListStateFlow.value = result.data
                }
                is DataResult.NoData -> {
                    _movieListStateFlow.value = emptyList()
                }
                is DataResult.Error -> {
                    Log.d("민규", "에러")
                }
            }
        }
    }
}