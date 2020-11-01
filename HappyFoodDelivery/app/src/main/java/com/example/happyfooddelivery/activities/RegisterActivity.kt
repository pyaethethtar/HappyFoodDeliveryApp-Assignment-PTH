package com.example.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.mvp.presenters.RegisterPresenter
import com.example.happyfooddelivery.mvp.presenters.impls.RegisterPresenterImpl
import com.example.happyfooddelivery.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterView {

    private lateinit var mPresenter : RegisterPresenter

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpPresenter()
        setUpListeners()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListeners(){

        btnSignUp.setOnClickListener {
            mPresenter.onTapSignUp(etUsername.text.toString(), etEmail.text.toString(), etPassword.text.toString(), etPhone.text.toString() )
        }

        btnLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }
}