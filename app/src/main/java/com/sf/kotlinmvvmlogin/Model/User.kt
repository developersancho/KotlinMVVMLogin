package com.sf.kotlinmvvmlogin.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email: String, private var password: String) : BaseObservable() {

    fun isDataValid(): Int {
        if (TextUtils.isEmpty(getEmail()))
            return 0 // code is email empty
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1 // code is wrong email pattern
        else if (getPassword().length < 7)
            return 2 // code is password must be greater than 6
        else
            return -1 // success
    }

    fun getPassword(): String {
        return password
    }

    fun getEmail(): String {
        return email
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun setEmail(email: String) {
        this.email = email
    }
}