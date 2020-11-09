package com.example.standardbankapp

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.example.sgbapp.R

class LoadingDialog(myActivity: Activity) {
    private val activity : Activity = myActivity
    private lateinit var  alertDialog : AlertDialog

    @SuppressLint("InflateParams")
    fun startDialog(){
        val builder = AlertDialog.Builder(activity)

        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.loading_dialog, null))
        builder.setCancelable(false)

        alertDialog = builder.create()
        alertDialog.show()
    }

    fun stopDialog(){
        alertDialog.dismiss()
    }

}