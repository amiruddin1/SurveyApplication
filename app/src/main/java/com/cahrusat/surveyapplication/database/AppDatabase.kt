package com.cahrusat.surveyapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cahrusat.surveyapplication.HealthCare
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberDao
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyDao
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity
import com.cahrusat.surveyapplication.database.HealthCare.HealthCareDao
import com.cahrusat.surveyapplication.database.HealthCare.HealthCareEntity
import com.cahrusat.surveyapplication.database.VillageData.VillageDao
import com.cahrusat.surveyapplication.database.VillageData.VillageEntity

@Database(entities = [VillageEntity::class, HeadOftheFamilyEntity::class, FamilyMemberEntity::class, HealthCareEntity::class], version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getVillageDao(): VillageDao
    abstract fun getHeadOftheFamilyDao(): HeadOftheFamilyDao
    abstract fun getFamilyMemberDao(): FamilyMemberDao
    abstract fun getHealthCareDao(): HealthCareDao
    companion object{
        private var db_instance:AppDatabase?=null
        fun getAppDatabaseInstance(context:Context):AppDatabase {
            if (db_instance == null) {
                db_instance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext, AppDatabase::class.java, "app_db"
                ).allowMainThreadQueries().build()
            }
            return db_instance!!
        }

    }
}