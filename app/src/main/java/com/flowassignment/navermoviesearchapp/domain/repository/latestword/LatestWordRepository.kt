package com.flowassignment.navermoviesearchapp.domain.repository.latestword

import com.flowassignment.navermoviesearchapp.domain.entity.DataResult

interface LatestWordRepository {
    suspend fun getLatestWordList(): DataResult<List<String>>
    suspend fun insetLatestWord(keyword: String)
}