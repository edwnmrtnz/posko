package com.github.posko.feature.addtocart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.posko.feature.base.BaseActivity
import com.github.posko.feature.base.replace

class AddToCartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addtocart_activity)

        replace(R.id.flContainer, AddToCartFragment())
    }
}
