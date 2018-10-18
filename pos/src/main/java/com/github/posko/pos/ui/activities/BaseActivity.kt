package com.github.posko.pos.ui.activities


import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.github.posko.pos.BuildConfig
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    protected fun isDebug() : Boolean {
        return BuildConfig.DEBUG;
    }

    protected fun log(tag : String, message : String) {
        if(isDebug()) Log.e(tag, message)
    }

    protected fun replaceFragmentInActivity(@NonNull fragmentManager: FragmentManager,
                                            @NonNull fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commit()
    }
}
