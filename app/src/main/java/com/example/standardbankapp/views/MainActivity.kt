package com.example.standardbankapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.example.sgbapp.R
import com.example.standardbankapp.viewmodel.LoginViewModel
import com.example.standardbankapp.views.signActivities.*

class MainActivity : AppCompatActivity() {

    lateinit var loginActivityViewModel : LoginViewModel
    private lateinit var mylist: ListView
    private val list = mutableListOf(
        "Using Fingerprint",
        "Voice Recognition",
        "Face Recognition",
        "With A 4-Digit PIN"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginActivityViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val btnLogout: Button = findViewById(R.id.btn_logout)

        mylist = findViewById(R.id.navigator_list)

        mylist.adapter = MyAdapter(this, R.layout.list_view, list)

        mylist.setOnItemClickListener { parent, _, position, _ ->

            navigator(parent, position)
        }

        btnLogout.setOnClickListener {
            loginActivityViewModel.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun navigator(parent: AdapterView<*>, position: Int) {
        when {
            parent.getItemAtPosition(position).toString() == "Using Fingerprint" -> {

                startActivity(Intent(this, FingerPrint::class.java))
                Toast.makeText(
                    this,
                    parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            parent.getItemAtPosition(position).toString() == "Voice Recognition" -> {

                startActivity(Intent(this, VoiceRecog::class.java))
                Toast.makeText(
                    this,
                    parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            parent.getItemAtPosition(position).toString() == "Face Recognition" -> {

                startActivity(Intent(this, FaceRecog::class.java))
                Toast.makeText(
                    this,
                    parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            parent.getItemAtPosition(position).toString() == "With A 4-Digit PIN" -> {

                startActivity(Intent(this, PinActivity::class.java))
                Toast.makeText(
                    this,
                    parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onStart() {
        mylist.adapter = MyAdapter(this, R.layout.list_view, list.shuffled())
        super.onStart()
    }

}