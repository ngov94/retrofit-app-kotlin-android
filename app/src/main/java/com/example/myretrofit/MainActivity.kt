package com.example.myretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    var bloodSugarListAPI = ArrayList<BloodSugar>()
    lateinit var adapter:BloodSugarAdapter
    lateinit var vm: BloodSugarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intr = RetroApiInterface.create()
        val repo = BloodSugarRepository(intr)
        vm = BloodSugarViewModel(repo)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerViewBS)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

//        vm.bSugarList.observe(this){
//            // attack to recycler view adapter
//            adapter = BloodSugarAdapter(it)
//            recyclerView.adapter = adapter
//        }

       // vm.getAllBloodSugarRecords()
//        vm.getAllApiBloodSugar().subscribe{
//            i -> bloodSugarListAPI.addAll(i)
//            println(bloodSugarListAPI)
//            adapter = BloodSugarAdapter(bloodSugarListAPI)
//            recyclerView.adapter = adapter
//        }

        vm.getAllApiBloodSugar()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    item ->
                    println("My Observable user list $item")
                    adapter = BloodSugarAdapter(item)
                    recyclerView.adapter = adapter
                },
                onError = {e -> "This is my error: $e"}
            )




        val fab: ExtendedFloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            val formIntent = Intent(this, BloodSugarForm::class.java)
            startActivity(formIntent)
        }


//        val api = RetroApiInterface.create().getAllBloodSugarRecords()
//        val recyclerView:RecyclerView = findViewById(R.id.recyclerViewBS)
//
//
//        api.enqueue(object: Callback<List<BloodSugar>>{
//            override fun onResponse(call: Call<List<BloodSugar>>, response: Response<List<BloodSugar>>) {
//                bloodSugarList = response.body() as ArrayList<BloodSugar>
//                adapter = BloodSugarAdapter(bloodSugarList)
//
//                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                recyclerView.adapter = adapter
//
//            }
//
//            override fun onFailure(call: Call<List<BloodSugar>>, t: Throwable) {
//                println(t.message)
//            }
//
//        })


    }
}


//Step 1: Add dependancy
//Step 2: Add permission to access internet in android policy
//Step 3: Create a retrofit instance
//Step 4: Create a retrofit interface
//Step 5:Consume REST API end points (response -> Success, error)
//Step 6: Process and attach it to you view (Recycler view)
