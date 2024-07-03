package com.example.medimate.screen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medimate.db.model.reminderEntity
import com.example.medimate.repository.ReminderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPlanViewModel @Inject constructor(
    private val repo : ReminderRepo
) : ViewModel() {
    private val _status: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val status: LiveData<String> get() = _status

    fun placeReminder(reminder: reminderEntity) = viewModelScope.launch {
        repo.saveToDatabase(reminder)
        _status.value = "Reminder added Successful!!"
    }

    fun addPlan(reminder: reminderEntity) {
        if (reminder.pillName.isNotEmpty() &&
            reminder.pillAmount != 0 &&
            reminder.pillType.isNotEmpty() &&
            reminder.interval != 0 &&
            reminder.intervalType.isNotEmpty() &&
            reminder.foodTiming != 0 &&
            reminder.time.isNotEmpty()
        ) {
            print(reminder)
            placeReminder(reminder)
        } else {
            _status.value = "Please Fill out all the fields!!"
        }
    }
}