package com.github.posko.feature.base.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.DialogFragment
import com.github.posko.feature.base.R
import java.lang.IllegalStateException

class LoadingProgressDialog : DialogFragment() {

    private lateinit var tvProgressTitle : AppCompatTextView
    private lateinit var tvProgressMessage : AppCompatTextView

    companion object {

        const val KEY_DIALOG_TITLE = "key_dialog_title"
        const val KEY_DIALOG_MESSAGE = "key_dialog_message"

        @JvmStatic
        fun newInstance(title : String?, message : String) : LoadingProgressDialog {
            val fragment = LoadingProgressDialog()
            val bundle = Bundle()
            bundle.putString(KEY_DIALOG_TITLE, title)
            bundle.putString(KEY_DIALOG_MESSAGE, message)
            fragment.arguments = bundle
            return fragment
        }
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
            tvProgressTitle         = findViewById(R.id.tvProgressTitle)
            tvProgressMessage       = findViewById(R.id.tvProgressMessage)
        }

        arguments?.let {
            val title   = it.getString(KEY_DIALOG_TITLE)
            val message = it.getString(KEY_DIALOG_MESSAGE)

            tvProgressTitle.text = if(title.isNullOrEmpty()) "Please wait..." else title
            tvProgressMessage.text = message

        } ?: throw IllegalStateException("Please pass a valid argument")

        return dialog.create()
    }

    fun showMessage(title : String?, message : String) {
        tvProgressTitle.text = if(title.isNullOrEmpty()) "Please wait..." else title
        tvProgressMessage.text = message
    }
}