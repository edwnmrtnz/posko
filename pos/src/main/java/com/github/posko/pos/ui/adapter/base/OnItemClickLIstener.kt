package com.github.posko.pos.ui.adapter.base

import android.view.View

interface OnItemClickLIstener {

    fun onitemClicked(view : View, position : Int)

    fun onItemLongClicked(view : View, position : Int)
}