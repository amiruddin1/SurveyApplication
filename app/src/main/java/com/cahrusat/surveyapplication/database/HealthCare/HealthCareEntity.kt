package com.cahrusat.surveyapplication.database.HealthCare

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_care_details")
class HealthCareEntity (
        @ColumnInfo(name = "health_center")val healthCenter:String,
        @ColumnInfo(name = "mode_transportation")val modeOfTransportation:String,
        @ColumnInfo(name = "distance_pharmacy")val distanceToPharmacy:Int,
        @ColumnInfo(name = "type_treatmement")val typeOfTreatment:String,
        @ColumnInfo(name = "first_action_health")val firstAction_health:String,
        @ColumnInfo(name = "preventive_home_care")val preventiveHomeCare:String,
        @ColumnInfo(name = "decision_maker")val decisionMaker:String,
        @ColumnInfo(name = "visited_charusat")val visitedCharusat:String,
        @ColumnInfo(name = "visited_charusat_detail")val visitedCharusatDetail:String,
        @ColumnInfo(name = "anyDeath")val anyDeath:String,
        @ColumnInfo(name = "anyDeath_detai")val anyDeathDetails:String,
        @ColumnInfo(name = "parent_identity")val parentIdentity:String,
        @ColumnInfo(name = "timestamp")val timeStamp:String,
    )
    {
        @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id")
        var id:Int=0
    }