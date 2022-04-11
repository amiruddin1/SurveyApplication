package com.cahrusat.surveyapplication.database.HeadOfFamily

import androidx.lifecycle.LiveData
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyDao
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity

class HeadOftheFamilyRepository(private val headOftheFamilyDao: HeadOftheFamilyDao) {
    val allHeads:LiveData<List<HeadOftheFamilyEntity>>
    =headOftheFamilyDao.getAllHeadDetail()
    suspend fun insert(headOftheFamilyEntity: HeadOftheFamilyEntity)
    {
        headOftheFamilyDao.insert(headOftheFamilyEntity)
    }
    suspend fun delete(headOftheFamilyEntity: HeadOftheFamilyEntity)
    {
        headOftheFamilyDao.delete(headOftheFamilyEntity)
    }
    suspend fun update(headOftheFamilyEntity: HeadOftheFamilyEntity)
    {
        headOftheFamilyDao.update(headOftheFamilyEntity)
    }
}