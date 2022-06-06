package com.example.myretrofit

//like the Entity in My First Room

data class BloodSugar(var sugar_conc: String,
                      var sugar_unit: String,
                      var measured: String,
                      var date: String,
                      var time: String,
                      var notes: String)