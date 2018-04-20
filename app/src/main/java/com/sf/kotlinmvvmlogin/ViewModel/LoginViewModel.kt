package com.sf.kotlinmvvmlogin.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sf.kotlinmvvmlogin.Interface.ILoginResultCallBacks
import com.sf.kotlinmvvmlogin.Model.User

class LoginViewModel(private val listener: ILoginResultCallBacks) : ViewModel() {
    private val user: User

    init {
        this.user = User("", "")
    }

    // create function to set email after user finish enter text
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user!!.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }


    // create function to set password after user finish enter text
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user!!.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    // create function to process Login button clicked
    fun onLoginClicked(v: View) {
        var loginCode: Int = user.isDataValid()
        if (loginCode == 0)
            listener.onError("Email must not be null")
        else if (loginCode == 1)
            listener.onError("Wrong email pattern")
        else if (loginCode == 2)
            listener.onError("Password length must greater than 6")
        else listener.onSuccess("Login success")
    }

}