package com.example.myretrofit

object Sample {
    fun validBloodSugar(bsugar: BloodSugar): Boolean{
        if(bsugar.id != null && bsugar.sugar_conc.isNotEmpty()){
            return true
        }
        return false
    }
}