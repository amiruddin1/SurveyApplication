package com.cahrusat.surveyapplication
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.famrecyclerstruct.view.*

class FamilyMemberAdapter(val items: LiveData<List<FamilyMemberEntity>>, val context:Context): RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder>()
{

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view)
    {
        val fName = view.familyMemberName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: kotlin.Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.famrecyclerstruct,parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: kotlin.Int)
    {
        holder.fName.text = items.get(position).memberName
    }
    override fun getItemCount(): kotlin.Int
    {
        return items.size
    }


}