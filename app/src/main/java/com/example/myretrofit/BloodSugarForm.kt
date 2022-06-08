package com.example.myretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_blood_sugar_form.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class BloodSugarForm : AppCompatActivity() {
    lateinit var vm: BloodSugarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_sugar_form)

        val intr = RetroApiInterface.create()
        val dao = AppDatabase.getInstance(this)?.bloodSugarDao()!!
        val repo = BloodSugarRepository(intr, dao)
        vm = BloodSugarViewModel(repo)

        submit.setOnClickListener {

            var sugar_conc = sugar_concV.text.toString()
            var sugar_unit = sugar_unitV.text.toString()
            var measured = measuredV.text.toString()
            var notes = notesV.text.toString()
            var time =  timeV.text.toString()
            var date = dateV.text.toString()

            var jsonObj = JSONObject()
            jsonObj.put("sugar_conc", "$sugar_conc")
            jsonObj.put("sugar_unit", "$sugar_unit")
            jsonObj.put("measured", "$measured")
            jsonObj.put( "date", "$date")
            jsonObj.put("time", "$time")
            jsonObj.put("notes", "$notes")

//            jsonObj.put("name", "neme")
//            jsonObj.put("username", "jgfdj34")
//            jsonObj.put("email", "email@hdjf.com")
//            jsonObj.put( "phone", "232-545-4534")
//            jsonObj.put("website", "")



            val requestBody = jsonObj.toString().toRequestBody("application/json".toMediaTypeOrNull())

            vm.createBloodSugar(requestBody)
            println(jsonObj.toString())

            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)

            Toast.makeText(this,"Submitted Data",Toast.LENGTH_LONG).show()
        }
    }
}


//1. Form with all the fields from the entity
//2. When user submits it get all the filled data and
//      create a json object using the data filled
//3. convert that json to string .toString
//4. convert the string to toRequestBody