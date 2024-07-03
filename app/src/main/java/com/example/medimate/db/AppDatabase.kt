package com.example.medimate.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.medimate.db.dao.ReminderDao
import com.example.medimate.db.model.reminderEntity

@Database(
    entities = [reminderEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    companion object{
        operator fun invoke(context: Context) = buildDatabase(context)

        private fun buildDatabase(context: Context):AppDatabase{
            val databaseBuilder = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MediMateDatabase.db"
            )
            return databaseBuilder.build()
        }
    }
}