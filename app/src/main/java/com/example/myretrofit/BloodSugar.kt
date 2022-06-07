package com.example.myretrofit

//like the Entity in My First Room

data class BloodSugar(var id: Int,//take out for no api
                      var sugar_conc: String,
                      var sugar_unit: String,
                      var measured: String,
                      var date: String,
                      var time: String,
                      var notes: String)