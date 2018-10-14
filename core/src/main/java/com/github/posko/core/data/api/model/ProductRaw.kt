package com.github.posko.core.data.api.model

data class ProductRaw(var id : Int,
                      var account_id : Int,
                      var title : String,
                      var vendor : String?,
                      var product_type : String?,
                      var status: String,
                      var product_status : Int,
                      var created_by_id : Int,
                      var created_at : String,
                      var updated_at : String)