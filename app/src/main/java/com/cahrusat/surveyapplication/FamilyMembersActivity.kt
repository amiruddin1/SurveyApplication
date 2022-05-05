package com.cahrusat.surveyapplication

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import kotlinx.android.synthetic.main.activity_family_members.*
import kotlinx.android.synthetic.main.member_dialog.*
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberAge
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberAgeContainer
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberEducation
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberEducationContainer
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberGenderContainer
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberHeight
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberIncome
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberIncomeContainer
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberName
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberNameContainer
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberOccupation
import kotlinx.android.synthetic.main.member_dialog.edtFamilyMemberOccupationContainer
import kotlinx.android.synthetic.main.member_dialog.edtGenderName
import kotlinx.android.synthetic.main.member_dialog.edtMeritalStatus
import java.text.SimpleDateFormat
import java.util.*

class FamilyMembersActivity : AppCompatActivity() {

    lateinit var viewModelFamilyMember: FamilyMemberActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_members)

        viewModelFamilyMember =
            ViewModelProvider(this).get(FamilyMemberActivityViewModel::class.java)

        var arr = viewModelFamilyMember.getRecordObserverMember()

        var ad = FamilyMemberAdapter(arr,this)


        addFamilyMember.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.member_dialog)
            dialog.setCancelable(false)
            val lp = WindowManager.LayoutParams()
            lp.copyFrom(dialog.window!!.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.gravity = Gravity.CENTER

            dialog.window!!.attributes = lp
            dialog.show()


            dialog.btnAddMemberDialogue.setOnClickListener {
                var builder = AlertDialog.Builder(this)
                builder.setMessage("Are you sure want to save details?")
                builder.setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        submitMemberForm()
                        // viewModelFamilyHead.AddFamilyHead()

                    })
                builder.setNegativeButton(
                    "No",
                    DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                var dialog = builder.create()
                dialog.setCancelable(false)
                dialog.show()
            }

            MemberNameFocusListener()
            MemberAgeFocusListener()
            MemberGenderFocusListener()
            MemberIncomeListener()
            MemberMarriedFocusListener()
            MemberEducationFocusListener()
            MemberOccupationFocusListener()
            MemberHightListener()
            MemberWeightListener()
            MemberBMIListener()
            MemberWaistSizeListener()


        }


    }

    private fun submitMemberForm() {

        edtFamilyMemberNameContainer.helperText = memberName()
        edtFamilyMemberAgeContainer.helperText = memberAge()
        edtFamilyMemberGenderContainer.helperText = memberGender()
        edtFamilyMemberIncomeContainer.helperText = memberIncome()
        edtFamilyMemberMaritalStatusContainer.helperText = memberMerital()
        edtFamilyMemberEducationContainer.helperText = memberEducation()

        edtFamilyMemberOccupationContainer.helperText = memberOccupation()
        edtFamilyMemberHeightContainer.helperText = memberHight()
        edtFamilyMemberWeightContainer.helperText = memberWeight()
        edtFamilyMemberBMIContainer.helperText = memberBMI()
        edtFamilyMemberWaistSizeContainer.helperText = memberWaist()

        // continue here ..
        //
        val validName = edtFamilyMemberNameContainer.helperText == null
        val validAge = edtFamilyMemberAgeContainer.helperText == null
        val validGender = edtFamilyMemberGenderContainer.helperText == null
        val validIncome = edtFamilyMemberIncomeContainer.helperText == null
        val validMarital = edtFamilyMemberMaritalStatusContainer.helperText == null
        val validEducation = edtFamilyMemberEducationContainer.helperText == null

        val validOccupation = edtFamilyMemberOccupationContainer.helperText == null
        val validHeight = edtFamilyMemberHeightContainer.helperText == null
        val validWeight = edtFamilyMemberWeightContainer.helperText == null
        val validBMI = edtFamilyMemberBMIContainer.helperText == null
        val validWaist = edtFamilyMemberWaistSizeContainer.helperText == null


        if (validName && validAge && validGender && validIncome && validMarital && validEducation &&
            validOccupation && validHeight && validWeight && validBMI && validWaist
        ) {
            val sharedpref: SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
            var read = sharedpref.getString("aadhar","tt")



            val sdf = SimpleDateFormat("dd MMM,yyyy - HH:mm")
            val currentdate = sdf.format(Date()).toDouble()

            val familyMember = FamilyMemberEntity(
                edtFamilyMemberName.text.toString(),
                edtFamilyMemberAge.text.toString().toInt(),
                edtGenderName.text.toString(),
                edtFamilyMemberIncome.text.toString().toDouble(),
                edtMeritalStatus.text.toString(),
                edtFamilyMemberEducation.text.toString(),
                edtFamilyMemberOccupation.text.toString(),
                edtFamilyMemberHeight.text.toString().toInt(),
                edtFamilyMemberWeight.text.toString().toDouble(),
                edtFamilyMemberBMI.text.toString().toDouble(),
                edtFamilyMemberWaistSize.text.toString().toDouble(),
                read ,
               currentdate
            )
           viewModelFamilyMember.AddFamilyMember(familyMember)
            Toast.makeText(this, "Family Head Added Successfully!!", Toast.LENGTH_LONG).show()
            var intent = Intent(this, FamilyMembersActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Please provide all data accurately!!", Toast.LENGTH_LONG).show()
        }
    }


    private fun MemberNameFocusListener() {
        edtFamilyMemberName.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberNameContainer.helperText = memberName()

            }
        }
    }

    private fun memberName(): CharSequence? {
        val name = edtFamilyMemberName.text.toString()
        if (TextUtils.isEmpty(name)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberAgeFocusListener() {
        edtFamilyMemberAge.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberAgeContainer.helperText = memberAge()

            }
        }
    }

    private fun memberAge(): CharSequence? {
        val age = edtFamilyMemberAge.text.toString()
        if (TextUtils.isEmpty(age)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberGenderFocusListener() {
        edtGenderName.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberGenderContainer.helperText = memberGender()

            }
        }
    }

    private fun memberGender(): CharSequence? {
        val gender = edtGenderName.text.toString()
        if (TextUtils.isEmpty(gender)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberIncomeListener() {
        edtFamilyMemberIncome.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberIncomeContainer.helperText = memberIncome()

            }
        }
    }

    private fun memberIncome(): CharSequence? {
        val income = edtFamilyMemberIncome.text.toString()
        if (TextUtils.isEmpty(income)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberMarriedFocusListener() {
        edtMeritalStatus.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberMaritalStatusContainer.helperText = memberMerital()

            }
        }
    }

    private fun memberMerital(): CharSequence? {
        val merital = edtMeritalStatus.text.toString()
        if (TextUtils.isEmpty(merital)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberEducationFocusListener() {
        edtFamilyMemberEducation.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberEducationContainer.helperText = memberEducation()

            }
        }
    }

    private fun memberEducation(): CharSequence? {
        val education = edtFamilyMemberEducation.text.toString()
        if (TextUtils.isEmpty(education)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberOccupationFocusListener() {
        edtFamilyMemberOccupation.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberOccupationContainer.helperText = memberOccupation()

            }
        }
    }

    private fun memberOccupation(): CharSequence? {
        val occupation = edtFamilyMemberOccupation.text.toString()
        if (TextUtils.isEmpty(occupation)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberHightListener() {
        edtFamilyMemberHeight.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberHeightContainer.helperText = memberHight()

            }
        }
    }

    private fun memberHight(): CharSequence? {
        val hight = edtFamilyMemberHeight.text.toString()
        if (TextUtils.isEmpty(hight)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberWeightListener() {
        edtFamilyMemberWeight.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberWeightContainer.helperText = memberWeight()

            }
        }
    }

    private fun memberWeight(): CharSequence? {
        val weight = edtFamilyMemberWeight.text.toString()
        if (TextUtils.isEmpty(weight)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberBMIListener() {
        edtFamilyMemberBMI.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberBMIContainer.helperText = memberBMI()

            }
        }
    }

    private fun memberBMI(): CharSequence? {
        val bmi = edtFamilyMemberBMI.text.toString()
        if (TextUtils.isEmpty(bmi)) {
            return "Must not be empty"
        }
        return null
    }

    private fun MemberWaistSizeListener() {
        edtFamilyMemberWaistSize.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFamilyMemberWaistSizeContainer.helperText = memberWaist()

            }
        }
    }

    private fun memberWaist(): CharSequence? {
        val waist = edtFamilyMemberWaistSize.text.toString()
        if (TextUtils.isEmpty(waist)) {
            return "Must not be empty"
        }
        return null
    }




}





