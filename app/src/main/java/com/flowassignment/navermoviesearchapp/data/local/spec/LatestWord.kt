package com.flowassignment.navermoviesearchapp.data.local.spec

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "LatestWord")
data class LatestWord(
    val word: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
