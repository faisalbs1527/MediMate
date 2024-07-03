package com.example.medimate.repository

import com.example.medimate.db.AppDatabase
import com.example.medimate.db.model.reminderEntity
import javax.inject.Inject

class ReminderRepo @Inject constructor(
    private val dbService: AppDatabase
) {

    suspend fun saveToDatabase(reminder: reminderEntity) {
        dbService.reminderDao().saveReminder(reminder)
    }

    suspend fun getReminders(): List<reminderEntity> {
        return dbService.reminderDao().getReminders()
    }
}