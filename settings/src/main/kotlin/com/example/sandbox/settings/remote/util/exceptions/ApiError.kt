package com.example.sandbox.settings.remote.util.exceptions

enum class ApiError(val value: String) {
    AUTH_001("AUTH-001"),
    AUTH_002("AUTH-002"),
    SHOP_02("SHOP-02"),
    PATIENT_01("PATIENT-01"),
    ;

    companion object {
        fun fromValue(value: String): ApiError? =
            entries.firstOrNull { it.value == value }
    }
}
