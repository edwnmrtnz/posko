package com.github.posko.feature.addtocart

import com.github.posko.feature.base.BasePresenter
import com.github.posko.feature.base.BaseView

/**
 * Created by edwinmartinez on November 22, 2019
 */
interface AddToCartContract {

    interface View : BaseView

    interface Presenter : BasePresenter<View>
}