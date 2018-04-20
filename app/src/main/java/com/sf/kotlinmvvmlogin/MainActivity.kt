package com.sf.kotlinmvvmlogin

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sf.kotlinmvvmlogin.Interface.ILoginResultCallBacks
import com.sf.kotlinmvvmlogin.ViewModel.LoginViewModel
import com.sf.kotlinmvvmlogin.ViewModel.LoginViewModelFactory
import com.sf.kotlinmvvmlogin.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), ILoginResultCallBacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)


    }


    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

}
