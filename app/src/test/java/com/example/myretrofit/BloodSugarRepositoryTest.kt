package com.example.myretrofit

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class BloodSugarRepositoryTest {

    lateinit var repo: BloodSugarRepository

    @Mock
    lateinit var dao: BloodSugarDao

    @Mock
    lateinit var inter: RetroApiInterface

    @Before()
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repo = BloodSugarRepository(inter, dao)
    }

    // this is a normal function returning observable
    @Test
    fun getAllApiBloodSugarTest(){
        val fakeList: List<BloodSugar> = (listOf<BloodSugar>(
            BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST")
        ))

        Mockito.`when`(inter.getAllApiBloodSugar()) //whenever repo.getall.. is called
            .thenReturn(Single.just(fakeList))//return this

        val result = repo.getAllApiBloodSugar()

        result.subscribeBy(
            onNext = {
                Assert.assertEquals(fakeList, it)
            },
            onError = {println("Error is: $it")}
        )
    }

    //Coroutines with Response object
    @Test
    fun getAllBloodSugarRecordsTest(){
        runBlocking {
            val fakeList: List<BloodSugar> = (listOf<BloodSugar>(
                BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST")
            ))

            Mockito.`when`(inter.getAllBloodSugarRecords()) //whenever repo.getall.. is called
                .thenReturn(Response.success(fakeList))//return this

            val response = repo.getAllBloodSugarRecords()

            assertEquals(fakeList, response.body())
        }
    }

}