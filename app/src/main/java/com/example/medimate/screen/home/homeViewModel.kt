package com.example.medimate.screen.home

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
class homeViewModel @Inject constructor(
    private val repo: ReminderRepo
) : ViewModel() {
    private val _status: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val status: LiveData<String> get() = _status

    private val _reminderList: MutableLiveData<List<reminderEntity>> by lazy {
        MutableLiveData<List<reminderEntity>>()
    }
    val reminderList: LiveData<List<reminderEntity>> get() = _reminderList

    fun getReminders() = viewModelScope.launch {
        _reminderList.value = repo.getReminders()
        _status.value = "Success"
    }
}