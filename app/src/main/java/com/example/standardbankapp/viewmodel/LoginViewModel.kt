package com.example.standardbankapp.viewmodel

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.standardbankapp.repository.FireAuthRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var fireAuthRepo : FireAuthRepo = FireAuthRepo(application)
    private var userLiveData: MutableLiveData<FirebaseUser>? = null
    private var loggedOutLiveData: MutableLiveData<Boolean>? = null

    init {
        this.userLiveData = fireAuthRepo.getCurrentUser()
        this.loggedOutLiveData = fireAuthRepo.getLoggedOutLiveData()
    }

     fun logout(){
        fireAuthRepo.logout()
    }

    fun  getUserMutableLiveData() : MutableLiveData<FirebaseUser>?{
        return userLiveData
    }

    fun getLoggedOutMutableLiveData() : MutableLiveData<Boolean>?{
        return loggedOutLiveData
    }

    fun login(email : String, password : String, activity: Activity){
        fireAuthRepo.login(email, password, activity)
        }
}