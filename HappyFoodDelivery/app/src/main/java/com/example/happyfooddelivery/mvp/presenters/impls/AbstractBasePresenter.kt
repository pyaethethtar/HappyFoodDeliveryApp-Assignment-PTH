package com.example.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.example.happyfooddelivery.mvp.presenters.BasePresenter
import com.example.happyfooddelivery.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {

    var mView : T ?= null

    override fun initPresenter(view: T) {
        mView = view
    }
}