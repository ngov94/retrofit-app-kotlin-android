package com.example.myretrofit

import androidx.room.Entity
import androidx.room.PrimaryKey

//like the Entity in My First Room

@Entity(tableName = "bloodsugar")
data class BloodSugar(@PrimaryKey var id: Int,
                      var sugar_conc: String,
                      var sugar_unit: String,
                      var measured: String,
                      var date: String,
                      var time: String,
                      var notes: String)