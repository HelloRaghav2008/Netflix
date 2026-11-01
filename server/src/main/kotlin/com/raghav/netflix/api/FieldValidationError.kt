package com.raghav.netflix.api

import kotlinx.serialization.Serializable

@Serializable
data class FieldValidationError(
    val field: String,
    val message: String,
)
