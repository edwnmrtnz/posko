package com.github.posko.feature.checkout

import com.github.posko.feature.base.BasePresenter
import com.github.posko.feature.base.BaseView

/**
 * Created by edwinmartinez on November 23, 2019
 */
interface CheckoutContract {

    interface View : BaseView

    interface Presenter : BasePresenter<View>

}