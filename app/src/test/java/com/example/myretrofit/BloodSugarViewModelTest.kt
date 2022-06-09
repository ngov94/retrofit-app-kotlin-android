package com.example.myretrofit

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class BloodSugarViewModelTest {
//    @Mock
//    @Before
//    @Test
//    @After

    // 1. add all the dependancy required for mockito
    // 2. Add class anotation @RunWith
//GIVEN
    // 3. Identify all the external dependancy and note it down
    // 4. Create any local objects needed
    // 5. Mock all the identified dependancies (@Mock (repo), @Before)
//WHEN
    // 6. Call the respective function on your mocked obj from
        // the function thaat needs to be tested
//THEN
    // 7. return Dummy
    // 8. Make the actual call -- which is verify
//AND
    // 9. Assert


//    @Test
//    fun `given repository when calling bsList then is empty and assert its empty`(){
//
//    }// can also write test case like this

    lateinit var bsvm: BloodSugarViewModel
//    lateinit var bsList: Observer<List<BloodSugar>>
//    lateinit var repo: BloodSugarRepository

    @Mock
    lateinit var repo: BloodSugarRepository

//    @Mock
//    lateinit var dao: BloodSugarDao
//
//    @Mock
//    lateinit var inter: RetroApiInterface

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
//        repo = BloodSugarRepository(inter, dao)
        bsvm = BloodSugarViewModel(repo)
//        setupObservers()
    }

//    private fun setupObservers(){
//        bsList = mock(Observer::class.java) as Observer<List<BloodSugar>>
//    }

    @Test
    fun getAllApiBloodSugarTest(){
        val fakeList: List<BloodSugar> = (listOf<BloodSugar>(
            BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST")
        ))

        Mockito.`when`(repo.getAllBloodSugar()) //whenever repo.getall.. is called
            .thenReturn(Observable.fromArray(fakeList))//return this

        val result = bsvm.getAllApiBloodSugar()

//        assertEquals(listOf<BloodSugar>(
//                            BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST"),
//                            BloodSugar(256, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST2")
//                        ), result)

        result.subscribeBy(
            onNext = {
                        assertEquals(listOf<BloodSugar>(
                            BloodSugar(253, "7.5", "mmol/L","After Dinner", "2022-06-08", "1:59", "Mockito TEST")
                        ), it)
                     },
            onError = {println("Error is: $it")}
        )
    }

}