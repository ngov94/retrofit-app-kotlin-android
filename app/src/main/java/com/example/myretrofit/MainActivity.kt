package com.example.myretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    var bloodSugarList = ArrayList<BloodSugar>()
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

        vm.bSugarList.observe(this){
            // attack to recycler view adapter
            adapter = BloodSugarAdapter(it)
            recyclerView.adapter = adapter
        }

        vm.getAllBloodSugarRecords()

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
