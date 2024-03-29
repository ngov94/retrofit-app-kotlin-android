package com.example.myretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import timber.log.Timber

class BloodSugarViewModel(private val repo: BloodSugarRepository) : ViewModel(){

    var bSugarList = MutableLiveData<List<BloodSugar>>()


    fun getAllBloodSugarRecords(){
        CoroutineScope(Dispatchers.IO).launch { //there are 3 types of dispatch...we want to use inputoutput b/c we are using get
            var res = repo.getAllBloodSugarRecords()
            if (res.isSuccessful){
                bSugarList.postValue(res.body())
            }
        }
    }

    fun getAllApiBloodSugar(): Observable<List<BloodSugar>> {
        Timber.d("timber inside view model")
        return repo.getAllBloodSugar()
    }


    fun createBloodSugar(@Body requestBody: RequestBody){
        CoroutineScope(Dispatchers.IO).launch {
            var res = repo.createBloodSugar(requestBody)
            if (res.isSuccessful){
                // response now is json
                val gson = GsonBuilder().setPrettyPrinting().create()
                val pJson = gson.toJson(
                    JsonParser.parseString(
                        res.body()?.string()
                    )
                )
                println(pJson)
            }
        }
    }

}


//Types of Testing Frameworks
//  1. JUnit + Mockito --> Unit Testing
//  2. Espresso --> UI Testing