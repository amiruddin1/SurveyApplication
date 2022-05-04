package com.cahrusat.surveyapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class FamilyMemberAdapter (val context: _root_ide_package_.android.content.Context, var arr:ArrayList<_root_ide_package_.com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity>)
    : RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder>()

{

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view)
    {
        fun bind(f:_root_ide_package_.com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity)
        {

        }
    }
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: kotlin.Int): com.cahrusat.surveyapplication.FamilyMemberAdapter.ViewHolder
    {
        TODO("Not yet implemented")
    }
    override fun onBindViewHolder(holder: com.cahrusat.surveyapplication.FamilyMemberAdapter.ViewHolder, position: kotlin.Int)
    {
        TODO("Not yet implemented")
    }
    override fun getItemCount(): kotlin.Int
    {
        TODO("Not yet implemented")
    }


}