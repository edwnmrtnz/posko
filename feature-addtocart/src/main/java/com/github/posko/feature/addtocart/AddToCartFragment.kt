package com.github.posko.feature.addtocart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.posko.feature.base.BaseFragment

class AddToCartFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.addtocart_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkRequirement()
    }

    private fun checkRequirement() {
        val id = getProductId()
        check(id >= 1) { "Product id is null" }
    }

    private fun getProductId(): Int {
        return arguments!!.getInt(KEY_PRODUCT_ID)
    }

    companion object {

        private const val KEY_PRODUCT_ID = "key_product_id"

        @JvmStatic
        fun newInstance(productId: Int): AddToCartFragment {
            val fragment = AddToCartFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_PRODUCT_ID, productId)
            fragment.arguments = bundle
            return fragment
        }
    }

}
