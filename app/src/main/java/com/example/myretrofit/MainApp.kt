package com.example.myretrofit

import android.app.Application
import timber.log.Timber

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()

        //Using Timber
        if(BuildConfig.DEBUG){
//            Timber.plant(Timber.DebugTree())

            Timber.plant(object : Timber.DebugTree(){
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format("Class ${super.createStackElementTag(element)} : Line ${element.lineNumber} : Method ${element.methodName}")
                }
            })
            //How your debug messages can be styled or even added more meta data

        }else{
            // build a custom class ReleaseTree and then make it act as an interceptor
            // which will collect all your logs and puts it to crashlytics
            Timber.plant(ReleaseTree())
        }
    }
}