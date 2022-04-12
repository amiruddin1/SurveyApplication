package com.cahrusat.surveyapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cahrusat.surveyapplication.database.*
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberRepository
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FamilyMemberActivityViewModel(application: Application) : AndroidViewModel(application) {
    val allMember: LiveData<List<FamilyMemberEntity>>
    val repository: FamilyMemberRepository

    init {
        val familyMemberDao = AppDatabase.getAppDatabaseInstance(application).getFamilyMemberDao()
        repository = FamilyMemberRepository(familyMemberDao)
        allMember = repository.allMembers
    }


    fun deleteFamilyMember(familyMemberEntity: FamilyMemberEntity) =
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.delete(familyMemberEntity)
        }

    fun getRecordObserverMember(): LiveData<List<FamilyMemberEntity>> {
        return allMember;
    }

    fun UpdateFamilyMember(familyMemberEntity: FamilyMemberEntity) =
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.update(familyMemberEntity)
        }

    fun AddFamilyMember(familyMemberEntity: FamilyMemberEntity) =
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insert(familyMemberEntity)
        }


}
