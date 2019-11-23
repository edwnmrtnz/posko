package com.github.posko.feature.addtocart

import javax.inject.Inject

/**
 * Created by edwinmartinez on November 22, 2019
 */
class AddToCartPresenter @Inject constructor(

) : AddToCartContract.Presenter {

    private var view : AddToCartContract.View? = null

    override fun takeView(view: AddToCartContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }
}