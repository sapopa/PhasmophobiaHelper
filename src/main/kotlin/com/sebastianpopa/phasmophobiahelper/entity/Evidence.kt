package com.sebastianpopa.phasmophobiahelper.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
class Evidence(
    @JsonIgnore
    @Id
    val id : UUID = UUID.randomUUID(),
    @NotNull
    @NotBlank
    @Column(unique = true)
    var name : String
)