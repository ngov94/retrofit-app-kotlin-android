package com.example.myretrofit

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroApiInterface {
    //provides the functions and the instance, which was separate in my first room

    @GET("ngov94")
    suspend fun getAllBloodSugarRecords(): Response<List<BloodSugar>>// where the call is actually happening
    //we are going to change this to suspend function
    //why? All the network calls should be part of coroutines
//    @GET("ngov94")
//    suspend fun getAllUsers(): Response<List<Users>>

    @POST("ngov94/post")
    suspend fun createBloodSugar(@Body requestBody: RequestBody): Response<ResponseBody>

    companion object{

//        private var BASE_URL = "https://ngov94.github.io/data/"

        private var BASE_URL = "https://f4ed-136-185-8-167.in.ngrok.io/"
        fun create(): RetroApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}