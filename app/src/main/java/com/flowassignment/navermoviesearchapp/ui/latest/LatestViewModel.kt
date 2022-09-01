package com.flowassignment.navermoviesearchapp.ui.latest

import android.util.Log
import androidx.lifecycle.ViewModel
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.entity.Movie
import com.flowassignment.navermoviesearchapp.domain.usecase.LatestWordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LatestViewModel @Inject constructor(
    private val latestWordUseCase: LatestWordUseCase
) : ViewModel() {

    private val _wordListStateFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val wordListStateFlow: StateFlow<List<String>> = _wordListStateFlow.asStateFlow()

    fun getWordList() {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = latestWordUseCase.getAll()) {
                is DataResult.Success -> {
                    _wordListStateFlow.value = result.data
                }
                is DataResult.NoData -> {
                    _wordListStateFlow.value = emptyList()
                }
                is DataResult.Error -> {
                    Log.d("민규", "에러")
                }
            }
        }
    }
}
