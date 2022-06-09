package com.example.myretrofit

import android.util.Log
import timber.log.Timber

class ReleaseTree: Timber.Tree() {
    //implement the log function
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
//        if need only error and warning use the if condition below

    //        if(priority == Log.ERROR || priority == Log.WARN){
//
//        }
        //        else send all error reports to crashlytics
    }
}