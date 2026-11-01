package com.raghav.netflix.api

import kotlinx.serialization.Serializable

@Serializable
data class ValidationErrorResponse(
    val code: String = "validation_error",
    val message: String = "One or more fields are invalid",
    val fields: List<FieldValidationError>,
    val requestId: String? = null,
)
