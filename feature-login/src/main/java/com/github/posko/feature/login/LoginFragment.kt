package com.github.posko.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.posko.domain.services.AuthenticationService
import com.github.posko.feature.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import javax.inject.Inject


class LoginFragment : BaseFragment() {

    @Inject
    lateinit var authenticationService: AuthenticationService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.scrollView.requestFocus()

        view.btnSignIn.setOnClickListener {
        }
    }


}
