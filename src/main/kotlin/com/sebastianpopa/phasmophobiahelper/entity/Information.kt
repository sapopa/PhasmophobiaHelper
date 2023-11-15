package com.sebastianpopa.phasmophobiahelper.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
class Information(
    @Id
    val id : UUID = UUID.randomUUID(),
    @NotNull
    @NotBlank
    var description: String,
    var isStrength: Boolean,
    var isUniqueBehaviour: Boolean,
    @ManyToOne
    @JoinColumn(name = "ghost_id")
    var ghost: Ghost
) {
    constructor(description: String, isStrength: Boolean, isUniqueBehaviour: Boolean, ghost: Ghost) : this(
        UUID.randomUUID(),
        description,
        isStrength,
        isUniqueBehaviour,
        ghost
    )
}