package com.github.posko.feature.base

/**
 * Created by edwinmartinez on July 07, 2019
 */
interface BasePresenter<View : BaseView> {

    fun takeView(view : View)

    fun destroy()
}