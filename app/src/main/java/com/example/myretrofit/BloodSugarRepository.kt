package com.example.myretrofit

import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody
import retrofit2.http.Body

class BloodSugarRepository(val inter: RetroApiInterface) {

    suspend fun getAllBloodSugarRecords() = inter.getAllBloodSugarRecords()

//    suspend fun getAllUsers() = inter.getAllUsers()

    fun getAllApiBloodSugar(): Observable<List<BloodSugar>>{
        return inter.getAllApiBloodSugar()
    }

    suspend fun createBloodSugar(@Body requestBody: RequestBody) = inter.createBloodSugar(requestBody)
}