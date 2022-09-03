package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.sharedpreferencesdemo.databinding.ActivityHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import splitties.activities.start

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener{
            /**
             * On clicking the button Logout we are changing the boolean value will be
             * set to false and if app open again then value in the check is been set to
             * false then it will route to LoginActivity
             * SharedPreferences.Editor helps in setting the value / put the value in the
             * Shared Preference  and the we have to use apply() to save the current set value for
             * the flag/ check as false again so again the user will have to do the login.
             */

            val sharePrefHome : SharedPreferences = getSharedPreferences("loginMod", MODE_PRIVATE)
            var editor : SharedPreferences.Editor = sharePrefHome.edit()
            editor.putBoolean("flag", false)
            editor.apply()
            lifecycleScope.launch {
                delay(2000)
                start<LoginActivity>()
                finish()
            }
        }
    }
}