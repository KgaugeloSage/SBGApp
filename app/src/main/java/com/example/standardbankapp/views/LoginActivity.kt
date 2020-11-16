package com.example.standardbankapp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sgbapp.R
import com.example.standardbankapp.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {

    lateinit var loginActivityViewModel : LoginViewModel
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btn_login)
        val edtEmail: EditText = findViewById(R.id.edt_email)
        val edtPassword: EditText = findViewById(R.id.edt_password)
        val hideShowPassword : TextView = findViewById(R.id.show_hide_password)

        loginActivityViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        loginActivityViewModel.getUserMutableLiveData()?.observe(this, Observer {
            if (it != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })

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
            when {
                edtEmail.text.toString() == "" -> {
                    edtEmail.error = "Enter Email"
                }
                edtPassword.text.toString() == "" -> {
                    edtPassword.error = "Enter Password"
                }
                else -> {
                    loginActivityViewModel.login(edtEmail.text.toString(), edtPassword.text.toString(), this)
                }
            }

        }

    }


}