package com.cahrusat.surveyapplication.database

import androidx.room.Embedded
import androidx.room.Relation
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import com.cahrusat.surveyapplication.database.HeadOfFamily.HeadOftheFamilyEntity

data class HeadWithMembers (
    @Embedded val family_head: HeadOftheFamilyEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val family_members:List<FamilyMemberEntity>
)