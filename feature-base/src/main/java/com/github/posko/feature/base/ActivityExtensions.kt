package com.github.posko.feature.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by edwinmartinez on June 20, 2019
 */

fun AppCompatActivity.replace (containerId : Int, fragmentInstance : Fragment) {
    supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragmentInstance)
            .commit()
}