package com.github.posko.feature.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.posko.feature.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject lateinit var presenter: HomePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.takeView(this)
    }


}
