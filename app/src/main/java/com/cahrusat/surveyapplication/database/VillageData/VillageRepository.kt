package com.cahrusat.surveyapplication.database.VillageData

import androidx.lifecycle.LiveData
import com.cahrusat.surveyapplication.database.VillageData.VillageDao
import com.cahrusat.surveyapplication.database.VillageData.VillageEntity

class VillageRepository(private val villageDao: VillageDao) {
    val allVillages:LiveData<List<VillageEntity>>
    =villageDao.getAllVillage()
    suspend fun insert(villageEntity: VillageEntity)
    {
        villageDao.insert(villageEntity)
    }
    suspend fun delete(villageEntity: VillageEntity)
    {
        villageDao.delete(villageEntity)
    }
    suspend fun update(villageEntity: VillageEntity)
    {
        villageDao.update(villageEntity)
    }
}