package com.github.posko.feature.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.posko.feature.base.BaseFragment
import com.github.posko.feature.base.delay
import javax.inject.Inject


class SplashFragment : BaseFragment() {

    @Inject lateinit var splashNavigation: SplashNavigation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_splash, container, false)

        Log.e("SplashFragment", "onCreateView")

        delay(5000) {
            splashNavigation.onDoneSplash(this)
        }

        return view
    }

}
