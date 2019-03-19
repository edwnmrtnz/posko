package com.github.posko.core.domain.model

import java.util.*

class Product (
        val id : Int,
        val accountId : Int,
        val title : String,
        val vendor : String?,
        val handle : String?,
        val productType : String,
        val status : String,
        val productStatus : String?,
        val createdAt : Date,
        val updatedAt : Date,
        val defaultVariantId: Int?
)