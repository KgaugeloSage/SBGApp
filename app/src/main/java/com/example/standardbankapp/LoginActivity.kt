package com.example.standardbankapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.sgbapp.R
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btn_login)
        val edtEmail: EditText = findViewById(R.id.edt_username)
        val edtPassword: EditText = findViewById(R.id.edt_password)
        val hideShowPassword : TextView = findViewById(R.id.show_hide_password)

        hideShowPassword.setOnClickListener {
            if (hideShowPassword.text.toString() == "SHOW"){
                edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                hideShowPassword.text = "HIDE"
            }else if (hideShowPassword.text.toString() == "HIDE"){
                edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                hideShowPassword.text = "SHOW"
            }
        }


        btnLogin.setOnClickListener {
           login(edtEmail.text.toString(),edtPassword.text.toString())
        }

    }

    private fun login(email : String, password : String) {
       val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }else{
                    Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
                }
            }
    }
}