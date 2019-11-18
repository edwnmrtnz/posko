package com.github.posko.domain.services.model

/**
 * Created by edwinmartinez on June 25, 2019
 */
data class PoskoUser (
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val suffix: String?
)