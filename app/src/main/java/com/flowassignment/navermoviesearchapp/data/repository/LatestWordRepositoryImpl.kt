package com.flowassignment.navermoviesearchapp.data.repository

import android.util.Log
import com.flowassignment.navermoviesearchapp.data.local.dao.LatestWordDao
import com.flowassignment.navermoviesearchapp.data.local.spec.LatestWord
import com.flowassignment.navermoviesearchapp.domain.entity.DataResult
import com.flowassignment.navermoviesearchapp.domain.repository.latestword.LatestWordRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LatestWordRepositoryImpl(
    private val latestWordDao: LatestWordDao,
    private val ioDispatcher: CoroutineDispatcher
) : LatestWordRepository {
    override suspend fun getLatestWordList(): DataResult<List<String>> =
        withContext(ioDispatcher) {
            try {
                val response = latestWordDao.getAll()
                if (response.isEmpty()) DataResult.Error("서버와 연결 오류")
                else {
                    val result: List<String> = response.map { it.word }
                    DataResult.Success(result)
                }
            } catch (e: Exception) {
                DataResult.Error("서버와 연결 오류")
            }
        }

    override suspend fun insetLatestWord(keyword: String) {
        latestWordDao.insertWord(LatestWord(keyword))
        val list = latestWordDao.getAll()
        if (list.size > 10) {
            latestWordDao.delete(list[0])
        }
    }
}