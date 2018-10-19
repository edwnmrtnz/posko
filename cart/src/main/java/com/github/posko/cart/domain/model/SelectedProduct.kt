package com.github.posko.cart.domain.model

class SelectedProduct private constructor(builder: Builder) {

    private val productId: Int?

    private val variantId: Int?

    private val unitId: Int?

    private val price: Double?

    private val quantity: Int?

    private val total: Double
        get() = quantity!! * price!!

    init {
        this.productId  = builder.productId
        this.variantId  = builder.variantId
        this.unitId     = builder.unitId
        this.price      = builder.price
        this.quantity   = builder.quantity
    }

    class Builder {

        var productId: Int? = null

        var variantId: Int? = null

        var unitId: Int? = null

        var price: Double? = null

        var quantity: Int? = null


        fun setProductId(productId: Int?): Builder {
            this.productId = productId
            return this
        }

        fun setVariantId(variantId: Int?): Builder {
            this.variantId = variantId
            return this
        }

        fun setUnitId(unitId: Int?): Builder {
            this.unitId = unitId
            return this
        }

        fun setPrice(price: Double?): Builder {
            this.price = price
            return this
        }

        fun setQuantity(quantity: Int?): Builder {
            this.quantity = quantity
            return this
        }

        fun create(): SelectedProduct {
            return SelectedProduct(this)
        }
    }

}
