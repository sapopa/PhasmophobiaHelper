package com.sebastianpopa.phasmophobiahelper.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
class Detail(
    @Id
    val id: UUID = UUID.randomUUID(),
    var summary: String,
    var information: InformationType,
    @ManyToOne(fetch = FetchType.LAZY)
    var ghost: Ghost
)