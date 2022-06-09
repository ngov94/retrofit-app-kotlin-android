package com.example.myretrofit

import org.junit.*

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)//can be added
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    @Before
//    fun addition_isCorrectBefore() {
//
//    }//before any test case (or function)
//    //to initialize values, example repo
//
//    @BeforeClass() //is before all test cases
//    fun b4Class(){
//
//    }
//
//    @After()
//    fun atAfter(){
//
//    }// can destroy the temp variables, objects that were created
//    //get rid of dummy files
//
//    @AfterClass()
//    fun afterClass(){
//
//    }
}