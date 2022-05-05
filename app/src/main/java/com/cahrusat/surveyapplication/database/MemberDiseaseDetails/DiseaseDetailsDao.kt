package com.cahrusat.surveyapplication.database.MemberDiseaseDetails


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DiseaseDetailsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(diseaseDetails: DiseaseDetailsEntity)

    @Update
    suspend fun update(diseaseDetails: DiseaseDetailsEntity)

    @Delete
    suspend fun delete(diseaseDetails: DiseaseDetailsEntity)

    @Transaction
    @Query("select * from DiseaseDetails where Ddetails_id=:id")
    fun getAllDetails(id:Int):LiveData<List<DiseaseDetailsEntity>>


}