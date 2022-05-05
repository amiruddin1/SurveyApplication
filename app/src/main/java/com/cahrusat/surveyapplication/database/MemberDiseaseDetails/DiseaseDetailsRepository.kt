package com.cahrusat.surveyapplication.database.MemberDiseaseDetails
import androidx.lifecycle.LiveData
import com.cahrusat.surveyapplication.database.MemberDiseaseDetails.DiseaseDetailsDao
import com.cahrusat.surveyapplication.database.MemberDiseaseDetails.DiseaseDetailsEntity

class DiseaseDetailsRepository (private val diseaseDetailsDao: DiseaseDetailsDao){
    val allDetails: LiveData<List<DiseaseDetailsEntity>>
            = diseaseDetailsDao.getAllDetails(1)
    suspend fun insert(diseaseDetailsEntity: DiseaseDetailsEntity)
    {
        diseaseDetailsDao.insert(diseaseDetailsEntity)
    }
    suspend fun delete(diseaseDetailsEntity: DiseaseDetailsEntity)
    {
        diseaseDetailsDao.delete(diseaseDetailsEntity)
    }
    suspend fun update(diseaseDetailsEntity: DiseaseDetailsEntity)
    {
        diseaseDetailsDao.update(diseaseDetailsEntity)
    }
}