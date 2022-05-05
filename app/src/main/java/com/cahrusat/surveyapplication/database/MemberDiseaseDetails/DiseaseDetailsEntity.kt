package com.cahrusat.surveyapplication.database.MemberDiseaseDetails
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DiseaseDetails")
class DiseaseDetailsEntity (
@ColumnInfo(name = "name")val Name:String,
@ColumnInfo(name = "blood_pressure")val bloodPressure:String,
@ColumnInfo(name = "family_history")val familyHistory:String,
@ColumnInfo(name = "treatment")val Treatment:Double,
@ColumnInfo(name = "BP_measurement_Systolic")val BPMeasurementSystolic:Double,
@ColumnInfo(name = "BP_measurement_Diastolic")val BPMeasurementDiastolic:Double,
@ColumnInfo(name = "member_id")val id:String?,
@ColumnInfo(name = "timestamp")val timeStamp:Double,
)
{
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="Ddetails_id")
    var d_id:Int=0
}