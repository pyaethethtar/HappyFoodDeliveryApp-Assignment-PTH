package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.BaseView

interface BasePresenter<T : BaseView>{

    fun initPresenter(view : T)
}