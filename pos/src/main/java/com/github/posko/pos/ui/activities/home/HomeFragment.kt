package com.github.posko.pos.ui.activities.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import com.github.posko.pos.R
import javax.inject.Inject

class HomeFragment @Inject constructor() : Fragment() {

    private lateinit var rvProducts : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        with(view) {
            rvProducts = findViewById(R.id.rv_products)
        }

        return view
    }


}
