package com.cahrusat.surveyapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.viewModelScope
import com.cahrusat.surveyapplication.database.*
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FamilyHeadActivityViewModel(application:Application)
    :AndroidViewModel(application)
{
        val allHeads:LiveData<List<HeadOftheFamilyEntity>>
        val repository: HeadOftheFamilyRepository

        init {
            val headOftheFamilyDao=AppDatabase.getAppDatabaseInstance(application).getHeadOftheFamilyDao()
            repository= HeadOftheFamilyRepository(headOftheFamilyDao)
            allHeads=repository.allHeads
        }
        fun deleteFamilyHead(headOftheFamilyEntity: HeadOftheFamilyEntity)=viewModelScope.launch(Dispatchers.IO)
        {
            repository.delete(headOftheFamilyEntity)
        }
        fun getRecordObserver():LiveData<List<HeadOftheFamilyEntity>>
        {
            return  allHeads;
        }
        fun UpdateFamilyHead(headOftheFamilyEntity: HeadOftheFamilyEntity)=viewModelScope.launch(Dispatchers.IO)
        {
            repository.update(headOftheFamilyEntity)
        }
        fun AddFamilyHead(headOftheFamilyEntity: HeadOftheFamilyEntity)=viewModelScope.launch(Dispatchers.IO)
        {
        repository.insert(headOftheFamilyEntity)
        }

}