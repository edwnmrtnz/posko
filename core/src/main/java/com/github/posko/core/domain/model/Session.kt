package com.github.posko.core.domain.model

data class Session(var id : String,
                   var domain : String,
                   var session_for : String,
                   var authToken : String,
                   var token : String)