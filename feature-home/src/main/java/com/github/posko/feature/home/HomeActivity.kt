package com.github.posko.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.posko.feature.base.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
    }
}
