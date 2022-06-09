package com.example.myretrofit

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class RetroApiInterfaceTest {

    lateinit var inter: RetroApiInterface

    lateinit var mockServer: MockWebServer

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        mockServer = MockWebServer()
        inter = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetroApiInterface::class.java)
    }

    // how to test for empty list
    @Test
    fun getAllBloodSugarRecordsTest(){
        runBlocking {
            //8
            var mockRes = MockResponse()
            mockServer.enqueue(mockRes.setBody("[]")) //Using mockito create a fake return object (like the fake list and mockito when from before)
            //9
            val res = inter.getAllBloodSugarRecords()
            val req = mockServer.takeRequest()
            //10
            assertEquals("/posts", req.path)
            assertEquals(true, res.body()?.isEmpty() == true)
        }
    }

    @After
    fun destroy(){
        mockServer.shutdown()
    }


}