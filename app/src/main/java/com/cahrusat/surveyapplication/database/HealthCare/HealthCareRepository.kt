package com.cahrusat.surveyapplication.database.HealthCare

import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity


class HealthCareRepository(private val healthCareDao: HealthCareDao) {
    suspend fun insert(healthcareEntity: HealthCareEntity)
    {
        healthCareDao.insert(healthcareEntity)
    }
    suspend fun delete(healthcareEntity: HealthCareEntity)
    {
        healthCareDao.delete(healthcareEntity)
    }
    suspend fun update(healthcareEntity: HealthCareEntity)
    {
        healthCareDao.update(healthcareEntity)
    }
}