package com.cahrusat.surveyapplication.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface FamilyMemberDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(familyMemberEntity: FamilyMemberEntity)

    @Update
    suspend fun update(familyMemberEntity: FamilyMemberEntity)

    @Delete
    suspend fun delete(familyMemberEntity: FamilyMemberEntity)

    @Transaction
    @Query("select * from family_members where id=:id")
     fun getAllFamilyMembers(id:Int):LiveData<List<FamilyMemberEntity>>



}