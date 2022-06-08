package com.example.myretrofit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface BloodSugarDao {
    @Query("select * from bloodsugar")
    fun selectAllBloodSugar(): Single<List<BloodSugar>>

    @Insert
    fun addBloodSugar(bs: BloodSugar)
}