package com.github.posko.pos.ui

interface BaseView {

    fun showToast(message : String)

    fun showLoading(message : String)

    fun hideLoading()

    fun showPopup(message : String)
}