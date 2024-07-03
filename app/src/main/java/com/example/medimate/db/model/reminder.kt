package com.example.medimate.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reminders")
data class reminderEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val pillName: String,
    val pillAmount: Int,
    val pillType: String,
    val interval: Int,
    val intervalType: String,
    val foodTiming: Int,
    val time: String
)
