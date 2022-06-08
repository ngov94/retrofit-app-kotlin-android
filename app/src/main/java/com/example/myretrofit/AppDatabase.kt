package com.example.myretrofit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BloodSugar::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase(){

    abstract fun bloodSugarDao(): BloodSugarDao

    companion object {
        var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if(INSTANCE == null) {

                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "bloodsugar.db")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}