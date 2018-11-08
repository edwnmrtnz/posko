package com.github.posko.pos.ui

interface BasePresenter<View : BaseView> {

    fun takeView(view : View)
}