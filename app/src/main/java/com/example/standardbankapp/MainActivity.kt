package com.example.standardbankapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.sgbapp.R
import com.example.standardbankapp.repository.signActivities.FaceRecog
import com.example.standardbankapp.repository.signActivities.FingerPrint
import com.example.standardbankapp.repository.signActivities.PinActivity
import com.example.standardbankapp.repository.signActivities.VoiceRecog

class MainActivity : AppCompatActivity() {

    private lateinit var mylist : ListView
    private val list = mutableListOf("Using Fingerprint","Voice Recognition","Face Recognition","With A 4-Digit PIN")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mylist = findViewById(R.id.navigator_list)


        mylist.adapter = MyAdapter(this, R.layout.list_view, list)

        mylist.setOnItemClickListener { parent, view, position, id ->

            if (parent.getItemAtPosition(position).toString()=="Using Fingerprint"){

                startActivity(Intent(this,FingerPrint::class.java))
                Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
            }else if (parent.getItemAtPosition(position).toString()=="Voice Recognition"){

                startActivity(Intent(this,VoiceRecog::class.java))
                Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
            }else if (parent.getItemAtPosition(position).toString()=="Face Recognition"){

                startActivity(Intent(this,FaceRecog::class.java))
                Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
            }else if (parent.getItemAtPosition(position).toString()=="With A 4-Digit PIN"){

                startActivity(Intent(this,PinActivity::class.java))
                Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        mylist.adapter = MyAdapter(this, R.layout.list_view, list.shuffled())
        Log.e("Main", "onStart started")
        super.onStart()
    }

}