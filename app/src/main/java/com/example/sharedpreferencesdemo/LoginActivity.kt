package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.sharedpreferencesdemo.databinding.ActivityLoginBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import splitties.activities.start

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            /**
             * On clicking the button Login we are changing the boolean value will be
             * set to true and if app open again then value in the check is been set to
             * true then it will route to HomeActivity
             * SharedPreferences.Editor helps in setting the value / put the value in the
             * Shared Preference  and the we have to use apply() to save the current set value for
             * the flag/ check as true.
             */
            val sharePrefLogin : SharedPreferences = getSharedPreferences("loginMod", MODE_PRIVATE)
            var editor : SharedPreferences.Editor = sharePrefLogin.edit()
            editor.putBoolean("flag", true)
            editor.apply()
            lifecycleScope.launch {
                delay(2000)
                start<HomeActivity>()
                finish()
            }
        }
    }
}