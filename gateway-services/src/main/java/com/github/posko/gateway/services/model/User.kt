package com.github.posko.gateway.services.model

/**
 * Created by edwinmartinez on June 25, 2019
 */
data class User (
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val suffix: String?
)