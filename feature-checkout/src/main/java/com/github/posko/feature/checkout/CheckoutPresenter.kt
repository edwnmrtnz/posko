package com.github.posko.feature.checkout

import javax.inject.Inject

/**
 * Created by edwinmartinez on November 23, 2019
 */
class CheckoutPresenter @Inject constructor(): CheckoutContract.Presenter {

    private var view : CheckoutContract.View? = null

    override fun takeView(view: CheckoutContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

}