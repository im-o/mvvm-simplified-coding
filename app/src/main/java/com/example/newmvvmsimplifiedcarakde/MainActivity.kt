package com.example.newmvvmsimplifiedcarakde

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.newmvvmsimplifiedcarakde.data.UserPreferences
import com.example.newmvvmsimplifiedcarakde.ui.auth.AuthActivity
import com.example.newmvvmsimplifiedcarakde.ui.home.HomeActivity
import com.example.newmvvmsimplifiedcarakde.utils.startNewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this) //not good idea, only for now
        userPreferences.authToken.asLiveData().observe(this, {
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        })
    }
}
