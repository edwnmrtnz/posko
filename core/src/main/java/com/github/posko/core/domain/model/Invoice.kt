package com.github.posko.core.domain.model

import java.util.*

/**
 * var id: Int,
var account_id : Int,
var user_id : Int,
var invoice_number: Int,
var note: String?,
var total_line_items_price : Double,
var total_discounts : Double?,
var subtotal : Double?,
var total_price : Double?,
var total_tax : Double?,
var total_weight : Double?,
var first_name : String?,
var middle_name : String?,
var last_name : String?,
var email : String?,
var contact_number : String?,
var suffix : String?,
var fulfillment_status: Int?,
var invoice_status: String,
var status : String,
var created_at : String,
var updated_at : String
 */
data class Invoice (
        var id : Int,
        var accountId : Int,
        var userId : Int,
        var invoiceNumber : Int,
        var note : String?,
        var totalLineItemsPrice : Double,
        var totalDiscount : Double?,
        var subtotal : Double?,
        var totalPrice : Double?,
        var totalTax : Double?,
        var totalWeight : Double?,
        var firstName : String?,
        var middleName : String?,
        var lastName : String?,
        var email : String?,
        var contactNumber : String?,
        var suffix : String?,
        var fulFillmentStatus : Int?,
        var invoiceStatus : String?,
        var status : String?,
        var created_at : Date,
        var updated_at : Date
)