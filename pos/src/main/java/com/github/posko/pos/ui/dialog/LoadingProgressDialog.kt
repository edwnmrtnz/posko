package com.github.posko.pos.ui.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatTextView
import com.github.posko.pos.R
import dagger.android.support.DaggerAppCompatDialogFragment


class LoadingProgressDialog : DaggerAppCompatDialogFragment() {

    private lateinit var tvProgressMessage : AppCompatTextView

    private var progressMessage = "Please wait..."

    fun setMessage(message : String) : LoadingProgressDialog {
        this.progressMessage = message
        return this
    }

    @SuppressLint("InflateParams")
    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.dialog_loading_progress, null)

        val dialog = AlertDialog.Builder(activity)
        dialog.setView(view)
        dialog.setCancelable(false)

        with(view) {
            tvProgressMessage = findViewById(R.id.tv_progress_message)
        }

        tvProgressMessage.text = progressMessage

        return dialog.create()
    }

}
