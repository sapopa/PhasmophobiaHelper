package com.sebastianpopa.phasmophobiahelper.entity

enum class InformationType(private val displayName: String) {
    DESCRIPTION("Description"),
    STRENGTH("Strength"),
    WEAKNESS("Weakness"),
    NEUTRAL("Neutral"),
    UNIQUE_BEHAVIOUR("Unique Behaviour");

    override fun toString(): String {
        return displayName
    }
}