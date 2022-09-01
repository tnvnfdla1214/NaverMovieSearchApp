package com.flowassignment.navermoviesearchapp.domain.usecase

import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.repository.latestword.LatestWordRepository
import javax.inject.Inject

class LatestWordUseCase @Inject constructor(
    private val latestWordRepository: LatestWordRepository
) {
    suspend fun getAll(): DataResult<List<String>> {
        return latestWordRepository.getLatestWordList()
    }

    suspend fun insertWord(keyword: String) =
        latestWordRepository.insetLatestWord(keyword)
}