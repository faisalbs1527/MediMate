package com.example.medimate.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.medimate.db.model.reminderEntity

@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveReminder(reminders: reminderEntity)

    @Query("SELECT * FROM Reminders")
    suspend fun getReminders(): List<reminderEntity>
}