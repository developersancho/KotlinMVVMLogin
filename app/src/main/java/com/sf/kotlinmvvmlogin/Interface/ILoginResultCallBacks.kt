package com.sf.kotlinmvvmlogin.Interface

interface ILoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}