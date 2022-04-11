package com.cahrusat.surveyapplication.database.FamilyMembers

import androidx.lifecycle.LiveData
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberDao
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity

class FamilyMemberRepository (private val familyMemberDao: FamilyMemberDao) {
    val allMembers: LiveData<List<FamilyMemberEntity>>
            = familyMemberDao.getAllFamilyMembers(1)
    suspend fun insert(familyMemberEntity: FamilyMemberEntity)
    {
        familyMemberDao.insert(familyMemberEntity)
    }
    suspend fun delete(familyMemberEntity: FamilyMemberEntity)
    {
        familyMemberDao.delete(familyMemberEntity)
    }
    suspend fun update(familyMemberEntity: FamilyMemberEntity)
    {
        familyMemberDao.update(familyMemberEntity)
    }
}