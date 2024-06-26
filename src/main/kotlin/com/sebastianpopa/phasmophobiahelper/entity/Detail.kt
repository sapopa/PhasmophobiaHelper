package com.sebastianpopa.phasmophobiahelper.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
class Detail(
    @Id
    val id: UUID = UUID.randomUUID(),
    var summary: String,
    var information: InformationType
)