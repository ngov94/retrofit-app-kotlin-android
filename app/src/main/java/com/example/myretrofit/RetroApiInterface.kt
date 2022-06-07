package com.example.myretrofit

import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface RetroApiInterface {
    //provides the functions and the instance, which was separate in my first room

    @GET("ngov94")
    //@GET("blood_sugar_data.json")
    suspend fun getAllBloodSugarRecords(): Response<List<BloodSugar>>// where the call is actually happening
    //we are going to change this to suspend function
    //why? All the network calls should be part of coroutines
//    @GET("ngov94")
//    suspend fun getAllUsers(): Response<List<Users>>

    @GET("ngov94/posts")
    fun getAllApiBloodSugar(): Observable<List<BloodSugar>>

    @POST("ngov94/posts")
    suspend fun createBloodSugar(@Body requestBody: RequestBody): Response<ResponseBody>

    companion object{

//        private var BASE_URL = "https://ngov94.github.io/data/"

        private var BASE_URL = "https://f4ed-136-185-8-167.in.ngrok.io/"
//        fun create(): RetroApiInterface{
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//            return retrofit.create(RetroApiInterface::class.java)
//        }
        fun create(): RetroApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}

// Using RXKotlin
// 1. add a function to your APIInterface getAllApiBloodSugar() Observable<List<BloodSugar>>
// 2. Go to repository (no more suspend functions) create a funciton getAllApiBloodSugar() Observable<List<BloodSugar>> return
// 3. Go to ViewModel, Create a function getAllApiBloodSugar() Observable<List<BloodSugar>>
    // if you want to .map, do it here
// 4. Go to the Activity, use the viewModel and call getAllApiBloodSugar()
    // subscribe on Schedulers.io (put it on a thread)
    // observeOn or .subscribe