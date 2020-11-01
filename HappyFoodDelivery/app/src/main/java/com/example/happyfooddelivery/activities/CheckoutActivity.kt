package com.example.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.mvp.presenters.CheckoutPresenter
import com.example.happyfooddelivery.mvp.presenters.impls.CheckoutPresenterImpl
import com.example.happyfooddelivery.mvp.views.CheckoutView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.bottomsheet_checkout.*

class CheckoutActivity : BaseActivity(), CheckoutView {


    private lateinit var mPresenter : CheckoutPresenter

    companion object{
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, CheckoutActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        setUpPresenter()
        mPresenter.onUiReady()

        btnComfirm.setOnClickListener {
            mPresenter.onTapConfirm()
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CheckoutPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDeliveryAddress(address: String) {
        tvDeliveryAddress.text = address
    }

    override fun displayBottomSheet() {
        val view=layoutInflater.inflate(R.layout.bottomsheet_checkout, null)
        val sheetDialog= BottomSheetDialog(this)
        sheetDialog.setContentView(view)
        sheetDialog.show()
    }
}