package com.example.myretrofit

import okhttp3.RequestBody
import retrofit2.http.Body

class BloodSugarRepository(val inter: RetroApiInterface) {

    suspend fun getAllBloodSugarRecords() = inter.getAllBloodSugarRecords()

//    suspend fun getAllUsers() = inter.getAllUsers()

    suspend fun createBloodSugar(@Body requestBody: RequestBody) = inter.createBloodSugar(requestBody)
}