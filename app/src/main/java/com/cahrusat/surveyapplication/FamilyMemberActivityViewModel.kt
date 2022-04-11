package com.cahrusat.surveyapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cahrusat.surveyapplication.database.*

class FamilyMemberActivityViewModel(application: Application)
    : AndroidViewModel(application){
    val allHeads:LiveData<List<FamilyMemberEntity>>
    val repository:FamilyMemberRepository
        init {
            val familyMemberDao= AppDatabase.getAppDatabaseInstance(application).getFamilyMemberDao()
            repository= FamilyMemberRepository(familyMemberDao)
            allHeads=repository.allMembers
        }
    }