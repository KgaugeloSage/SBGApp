package com.example.standardbankapp

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sgbapp.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val editText = findViewById<EditText>(R.id.editTextTextPassword123)

        editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
    }
}