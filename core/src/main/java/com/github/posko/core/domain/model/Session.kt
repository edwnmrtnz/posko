package com.github.posko.core.domain.model

data class Session(var id : Int,
                   var domain : String,
                   var authToken : String,
                   var token : String)