package com.github.posko.feature.home

import com.github.posko.feature.base.BasePresenter
import com.github.posko.feature.base.BaseView

/**
 * Created by edwinmartinez on November 18, 2019
 */
interface HomeContract {

    interface View : BaseView

    interface Presenter : BasePresenter<View>
}