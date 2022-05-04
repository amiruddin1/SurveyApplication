package com.cahrusat.surveyapplication

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.cahrusat.surveyapplication.database.FamilyMembers.FamilyMemberEntity
import com.cahrusat.surveyapplication.database.HealthCare.HealthCareEntity
import kotlinx.android.synthetic.main.activity_family_head.*
import kotlinx.android.synthetic.main.activity_health_care.*
import kotlinx.android.synthetic.main.member_dialog.*
import java.text.SimpleDateFormat
import java.util.*

class HealthCare : AppCompatActivity() {

    lateinit var viewModelHealthcare: HealthCareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_care)

        viewModelHealthcare =
            ViewModelProvider(this).get(HealthCareViewModel::class.java)

        btnAddHealthCareDetails.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure want to save details?")
            builder.setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    submitHealthCareDetailsForm()
                    // viewModelFamilyHead.AddFamilyHead()

                })
            builder.setNegativeButton(
                "No",
                DialogInterface.OnClickListener { dialogInterface, i ->

                })
            builder.show()
        }

        HealthCenterFocusListener()
        ModeTransportationFocusListener()
        DistancePharmacyFocusListener()
        TypeTreatmentListener()
        FirstActionHealthFocusListener()
        PreventiveHomeCareFocusListener()
        DecisionMakerFocusListener()
        VisitedCharusatListener()
        VisitedCharusatDetailsListener()
        AnyDeathListener()

    }

    fun submitHealthCareDetailsForm()
    {
        edthealthcenternameContainer.helperText = healthCenter();
        edtDistanceContainer.helperText = Distance()
        edtmodetransportationContainer.helperText = modetransportation();
        edtTypeTreatementContainer.helperText = TypeTreatement()
        edtFirstActionHealthContainer.helperText = FirstActionHealth()
        edtpreventingHomeCareContainer.helperText = preventingHomeCare()
        edtdesicionMakerContainer.helperText = DecisionMaker()
        edtvisitedCharusatContainer.helperText = visitedCharusat()
        edtvisitedCharusatDetailContainer.helperText = visitedCharusatDetails()
        edtanyDeathContainer.helperText = DeathMember()

        val var1 = edthealthcenternameContainer.helperText == null
        val var2 = edtDistanceContainer.helperText == null
        val var3 = edtmodetransportationContainer.helperText == null
        val var4 = edtTypeTreatementContainer.helperText == null
        val var5 = edtFirstActionHealthContainer.helperText == null
        val var6 = edtpreventingHomeCareContainer.helperText == null
        val var7 = edtdesicionMakerContainer.helperText == null
        val var8 = edtvisitedCharusatContainer.helperText == null
        val var9 = edtvisitedCharusatDetailContainer.helperText == null
        val var10 = edtanyDeathContainer.helperText == null

        if(var1 && var2 && var3 && var4 && var5 && var6 && var7 && var8 && var9 && var10)
        {
            val sharedpref: SharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
            var read = sharedpref.getString("aadhar","tt")

            val sdf = SimpleDateFormat("dd MMM,yyyy - HH:mm")
            val currentdate = sdf.format(Date()).toDouble()

            val healthcare = HealthCareEntity(
                edthealthcentername.text.toString(),
                edtmodetransportation.text.toString(),
                edtdistancePharmacy.text.toString().toInt(),
                edtTypeTreatement.text.toString(),
                edtFirstActionHealth.text.toString(),
                edtpreventingHomeCare.text.toString(),
                edtdesicionMaker.text.toString(),
                edtvisitedCharusat.text.toString(),
                edtvisitedCharusatDetail.text.toString(),
                edtanyDeath.text.toString(),
                edtanyDeathDetail.text.toString(),
                read.toString(),
                currentdate.toString()
            )
            viewModelHealthcare.AddHealthCare(healthcare)
            Toast.makeText(this, "Health Care Details Submitted Successfully!!", Toast.LENGTH_LONG).show()
            var intent = Intent(this, FamilyMembersActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this, "Please provide all data accurately!!", Toast.LENGTH_LONG).show()
        }

    }

    private fun HealthCenterFocusListener() {
        edthealthcentername.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edthealthcenternameContainer.helperText = healthCenter()

            }
        }
    }

    private fun healthCenter(): CharSequence? {
        val name = edthealthcentername.text.toString()
        if (TextUtils.isEmpty(name)) {
            return "Must not be empty"
        }
        return null
    }

    private fun ModeTransportationFocusListener() {
        edtmodetransportation.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtmodetransportationContainer.helperText = modetransportation()

            }
        }
    }

    private fun modetransportation(): CharSequence? {
        val age = edtmodetransportation.text.toString()
        if (TextUtils.isEmpty(age)) {
            return "Must not be empty"
        }
        return null
    }

    private fun DistancePharmacyFocusListener() {
        edtdistancePharmacy.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {
                edtdistancePharmacyContainer.helperText = Distance()
            }
        }
    }

    private fun Distance(): CharSequence? {
        val gender = edtdistancePharmacy.text.toString()
        if (TextUtils.isEmpty(gender)) {
            return "Must not be empty"
        }
        return null
    }

    private fun TypeTreatmentListener() {
        edtTypeTreatement.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtTypeTreatementContainer.helperText = TypeTreatement()

            }
        }
    }

    private fun TypeTreatement(): CharSequence? {
        val income = edtTypeTreatement.text.toString()
        if (TextUtils.isEmpty(income)) {
            return "Must not be empty"
        }
        return null
    }

    private fun FirstActionHealthFocusListener() {
        edtFirstActionHealth.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtFirstActionHealthContainer.helperText = FirstActionHealth()

            }
        }
    }

    private fun FirstActionHealth(): CharSequence? {
        val merital = edtFirstActionHealth.text.toString()
        if (TextUtils.isEmpty(merital)) {
            return "Must not be empty"
        }
        return null
    }

    private fun PreventiveHomeCareFocusListener() {
        edtpreventingHomeCare.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtpreventingHomeCareContainer.helperText = preventingHomeCare()

            }
        }
    }

    private fun preventingHomeCare(): CharSequence? {
        val education = edtpreventingHomeCare.text.toString()
        if (TextUtils.isEmpty(education)) {
            return "Must not be empty"
        }
        return null
    }

    private fun DecisionMakerFocusListener() {
        edtdesicionMaker.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtdesicionMakerContainer.helperText = DecisionMaker()

            }
        }
    }

    private fun DecisionMaker(): CharSequence? {
        val occupation = edtdesicionMaker.text.toString()
        if (TextUtils.isEmpty(occupation)) {
            return "Must not be empty"
        }
        return null
    }

    private fun VisitedCharusatListener() {
        edtvisitedCharusat.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtvisitedCharusatContainer.helperText = visitedCharusat()

            }
        }
    }

    private fun visitedCharusat(): CharSequence? {
        val hight = edtvisitedCharusat.text.toString()
        if (TextUtils.isEmpty(hight)) {
            return "Must not be empty"
        }
        return null
    }

    private fun VisitedCharusatDetailsListener() {
        edtvisitedCharusatDetail.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtvisitedCharusatDetailContainer.helperText = visitedCharusatDetails()

            }
        }
    }

    private fun visitedCharusatDetails(): CharSequence? {
        val weight = edtvisitedCharusatDetail.text.toString()
        if (TextUtils.isEmpty(weight)) {
            return "Must not be empty"
        }
        return null
    }

    private fun AnyDeathListener() {
        edtanyDeath.setOnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                edtanyDeathContainer.helperText = DeathMember()

            }
        }
    }

    private fun DeathMember(): CharSequence? {
        val bmi = edtanyDeath.text.toString()
        if (TextUtils.isEmpty(bmi)) {
            return "Must not be empty"
        }
        return null
    }


}