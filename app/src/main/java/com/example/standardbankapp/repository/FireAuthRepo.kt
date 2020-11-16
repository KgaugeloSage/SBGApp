package com.example.standardbankapp.repository

import android.app.Activity
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.standardbankapp.views.LoadingDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class FireAuthRepo(application: Application) {

    private val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()
    private var application: Application? = null
    private var userLiveData: MutableLiveData<FirebaseUser>? = null
    private var loggedOutLiveData: MutableLiveData<Boolean>? = null

    init {
        this.application = application
        this.userLiveData = MutableLiveData()
        this.loggedOutLiveData = MutableLiveData()

        if (firebaseAuth.currentUser != null){
            userLiveData?.postValue(firebaseAuth.currentUser)
            loggedOutLiveData?.postValue(false)
        }else{
            loggedOutLiveData?.postValue(false)
        }
    }

     fun login(email: String, password: String, activity: Activity) {
       val loadingDialog = LoadingDialog(activity)
        loadingDialog.startDialog()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    userLiveData?.postValue(firebaseAuth.currentUser)
                    Toast.makeText(application?.applicationContext, "Welcome "+firebaseAuth.currentUser?.email, Toast.LENGTH_SHORT).show()
                    loadingDialog.stopDialog()
                    activity.finish()
                }else{
                    Toast.makeText(application?.applicationContext, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
                    loadingDialog.stopDialog()
                }
            }

    }

    fun getLoggedOutLiveData() : MutableLiveData<Boolean>?{
        return loggedOutLiveData
    }

    fun getCurrentUser() : MutableLiveData<FirebaseUser>?{
        return userLiveData
    }

    fun logout(){
        firebaseAuth.signOut()
    }
}