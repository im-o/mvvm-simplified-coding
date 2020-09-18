package com.example.newmvvmsimplifiedcarakde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newmvvmsimplifiedcarakde.ui.auth.AuthActivity
import com.example.newmvvmsimplifiedcarakde.utils.openActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        finish()
        openActivity(AuthActivity::class.java)
    }
}
