package com.example.myretrofit

import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody
import retrofit2.http.Body

class BloodSugarRepository(val inter: RetroApiInterface, private val dao: BloodSugarDao) {



    suspend fun getAllBloodSugarRecords() = inter.getAllBloodSugarRecords()

//    suspend fun getAllUsers() = inter.getAllUsers()

    fun getAllBloodSugar(): Observable<List<BloodSugar>>{
        val concat = Observable.concatArray( getAllApiBloodSugar(), getAllDBBloodSugar())
        return concat
    }

    private fun getAllApiBloodSugar(): Observable<List<BloodSugar>>{
        return inter.getAllApiBloodSugar()
            .toObservable()
            .filter { it.isNotEmpty() }
    }

    private fun getAllDBBloodSugar(): Observable<List<BloodSugar>>{
        //addBloodSugar()
        return dao.selectAllBloodSugar()
            .toObservable()
            .filter { it.isNotEmpty() }
    }

//    fun addBloodSugar(){
//        dao.addBloodSugar(BloodSugar(75, "1.9", "mmol/L","After Dinner", "2022-06-07", "15:34", "From DB"))
//    }



    suspend fun createBloodSugar(@Body requestBody: RequestBody) = inter.createBloodSugar(requestBody)
}