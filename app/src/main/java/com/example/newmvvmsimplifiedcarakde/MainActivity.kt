package com.example.newmvvmsimplifiedcarakde

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.newmvvmsimplifiedcarakde.data.UserPreferences
import com.example.newmvvmsimplifiedcarakde.ui.auth.AuthActivity
import com.example.newmvvmsimplifiedcarakde.utils.myToast
import com.example.newmvvmsimplifiedcarakde.utils.openActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this) //not good idea, only for now
        userPreferences.authToken.asLiveData().observe(this, {
            myToast(it ?: "Token is Null")
            finish()
            openActivity(AuthActivity::class.java)
        })
    }
}
