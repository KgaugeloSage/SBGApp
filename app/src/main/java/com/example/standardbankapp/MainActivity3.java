package com.example.standardbankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.widget.EditText;

import com.example.sgbapp.R;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText editText = findViewById(R.id.editTextTextPassword123);

        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }
}