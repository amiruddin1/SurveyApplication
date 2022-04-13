package com.cahrusat.surveyapplication.database.HealthCare

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HealthCareDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(healthCareEntity: HealthCareEntity)

    @Update
    suspend fun update(healthCareEntity: HealthCareEntity)

    @Delete
    suspend fun delete(healthCareEntity: HealthCareEntity)

    @Query("select * from health_care_details")
    fun getAllHeadDetail(): LiveData<List<HealthCareEntity>>

}