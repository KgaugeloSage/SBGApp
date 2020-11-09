package com.example.standardbankapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sgbapp.R
import com.google.firebase.auth.FirebaseAuth


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = FirebaseAuth.getInstance().currentUser

        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(
            {
                if (user != null) {
                    Toast.makeText(this@SplashScreen,"Welcome", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                } else {
                    Toast.makeText(this@SplashScreen,"Please Login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
                }

                finish()
            }, 4000
        )
    }
}