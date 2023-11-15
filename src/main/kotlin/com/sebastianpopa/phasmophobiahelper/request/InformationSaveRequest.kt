package com.sebastianpopa.phasmophobiahelper.request

data class InformationSaveRequest(
    val description: String,
    val isStrength: Boolean,
    val isUniqueBehaviour: Boolean,
    val ghostName: String
)
