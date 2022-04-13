package com.cahrusat.surveyapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cahrusat.surveyapplication.database.AppDatabase
import com.cahrusat.surveyapplication.database.HealthCare.HealthCareEntity
import com.cahrusat.surveyapplication.database.HealthCare.HealthCareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HealthCareViewModel(application: Application)
    : AndroidViewModel(application) {

    val repository: HealthCareRepository

    init {
        val healthcareDao= AppDatabase.getAppDatabaseInstance(application).getHealthCareDao()
        repository= HealthCareRepository(healthcareDao)
    }
    fun deleteHealthCare(healthCareEntity: HealthCareEntity)=viewModelScope.launch(
        Dispatchers.IO)
    {
        repository.delete(healthCareEntity)
    }
    fun UpdateHealthCare(healthCareEntity: HealthCareEntity)=viewModelScope.launch(
        Dispatchers.IO)
    {
        repository.update(healthCareEntity)
    }
    fun AddHealthCare(healthCareEntity: HealthCareEntity)=viewModelScope.launch(
        Dispatchers.IO)
    {
        repository.insert(healthCareEntity)
    }
}