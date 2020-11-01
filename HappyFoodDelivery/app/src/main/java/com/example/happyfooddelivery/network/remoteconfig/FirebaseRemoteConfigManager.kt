package com.example.groceryapppth.network.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object FirebaseRemoteConfigManager {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun setUpRemoteConfigWithDefaultValues(){
        val defaultValues : Map<String, Any> = hashMapOf(
            "viewType" to 0)
        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfigs(){
        remoteConfig.fetch().addOnCompleteListener {task ->
            if (task.isSuccessful){
                Log.e("Firebase", "Firebase Remote Config fetch Successful!")
                remoteConfig.activate().addOnCompleteListener {
                    Log.e("Firebase", "Firebase Remote Config Activated!")
                }
            } else{
                Log.e("Firebase", "Firebase Remote Config fetch Failed!")
            }
        }
    }


    fun getViewType() : Int{
        return remoteConfig.getValue("viewType").asLong().toInt()
    }
}