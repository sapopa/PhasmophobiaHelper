package com.sebastianpopa.phasmophobiahelper.request

data class InformationRequest(
    val ghostName: String,
    val isStrength: Boolean = false,
    val isUniqueBehaviour: Boolean = false
)