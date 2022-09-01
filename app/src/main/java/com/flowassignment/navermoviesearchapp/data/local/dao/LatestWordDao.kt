package com.flowassignment.navermoviesearchapp.data.local.dao

import androidx.room.*
import com.flowassignment.navermoviesearchapp.data.local.spec.LatestWord

@Dao
interface LatestWordDao {
    @Query("SELECT * FROM LatestWord")
    fun getAll(): List<LatestWord>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(latestWord: LatestWord)

    @Delete
    fun delete(latestWord: LatestWord)
}