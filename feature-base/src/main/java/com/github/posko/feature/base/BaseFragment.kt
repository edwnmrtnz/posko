package com.github.posko.feature.base

import com.github.posko.feature.base.dialog.LoadingProgressDialog
import dagger.android.support.DaggerFragment

/**
 * Created by edwinmartinez on June 23, 2019
 */
abstract class BaseFragment : DaggerFragment () {

    private var loadingProgressDialog : LoadingProgressDialog? = null

    protected fun showLoadingProgressDialog(title : String?, message : String) {
        if(loadingProgressDialog != null)
            loadingProgressDialog = LoadingProgressDialog.newInstance(title, message)

        if(loadingProgressDialog!!.isVisible)
            loadingProgressDialog!!.showMessage(title, message)
        else
            loadingProgressDialog!!.show(fragmentManager!!, "loading_progress_dialog")
    }

    protected fun hideLoadingProgressDialog() {
        loadingProgressDialog?.dismiss()
    }

}