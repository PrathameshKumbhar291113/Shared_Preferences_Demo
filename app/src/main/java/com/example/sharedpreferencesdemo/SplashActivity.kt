package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import splitties.activities.start

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        /**
          Getting the reference of the shared preference and getting the default value
          as false , If the user is already logged in then route to home activity else route
          to login activity.
         */

        val sharePref : SharedPreferences = getSharedPreferences("loginMod", MODE_PRIVATE)
        var isLoggedIn = sharePref.getBoolean("flag",false)

        if (isLoggedIn){
            lifecycleScope.launch {
                delay(2000)
                start<HomeActivity>()
                finish()
            }

        }else{
            lifecycleScope.launch {
                delay(2000)
                start<LoginActivity>()
                finish()
            }
        }
    }
}