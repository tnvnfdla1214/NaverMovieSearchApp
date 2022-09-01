package com.flowassignment.navermoviesearchapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flowassignment.navermoviesearchapp.data.local.dao.LatestWordDao
import com.flowassignment.navermoviesearchapp.data.local.spec.LatestWord


@Database(entities = [LatestWord::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun latestWordDao(): LatestWordDao
}