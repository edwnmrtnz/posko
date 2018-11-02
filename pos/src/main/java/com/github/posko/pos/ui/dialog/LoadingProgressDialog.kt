package com.github.posko.pos.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.github.posko.pos.R
import dagger.android.support.DaggerDialogFragment

import dagger.android.support.DaggerFragment

class LoadingProgressDialog : DaggerDialogFragment() {

    private lateinit var tvProgressMessage : AppCompatTextView

    private var progressMessage = "Please wait..."


    public fun setMessage(message : String) : LoadingProgressDialog {
        this.progressMessage = message
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_loading_progress, container, false)

        with(view) {
            tvProgressMessage = findViewById(R.id.tv_progress_message)
        }

        tvProgressMessage.text = progressMessage

        return view
    }
}
