package com.sf.kotlinmvvmlogin.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sf.kotlinmvvmlogin.Interface.ILoginResultCallBacks

class LoginViewModelFactory(private val listener: ILoginResultCallBacks) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }

}