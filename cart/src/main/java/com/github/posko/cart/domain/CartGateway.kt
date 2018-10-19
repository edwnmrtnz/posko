package com.github.posko.cart.domain

import com.github.posko.cart.domain.model.SelectedProduct


interface CartGateway {

    fun addToCart(selectedProduct: SelectedProduct)

    fun deleteFromCart(selectedProduct: SelectedProduct)

}