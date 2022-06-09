package com.example.myretrofit


import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SampleTest {

    @Test
    fun validBloodSugarTest(){
        val bsugar = BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "UNIT TEST")
        assertEquals(true, Sample.validBloodSugar(bsugar))
    }


    @Test
    fun validBloodSugarEmptySugarConcTest(){
        val bsugar = BloodSugar(254, "", "mmol/L","After Dinner", "2022-06-08", "1:59", "UNIT TEST")
        assertEquals(false, Sample.validBloodSugar(bsugar))
    }

//    @Test
//    fun validBloodSugarEmptyIDTest(){
//        val bsugar = BloodSugar(null, "6.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "UNIT TEST")
//        assertEquals(false, Sample.validBloodSugar(bsugar))
//    }

}