package com.github.posko.feature.home

import javax.inject.Inject

/**
 * Created by edwinmartinez on November 18, 2019
 */
class HomePresenter @Inject constructor() : HomeContract.Presenter {

    private var view : HomeContract.View? = null

    override fun takeView(view: HomeContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

}