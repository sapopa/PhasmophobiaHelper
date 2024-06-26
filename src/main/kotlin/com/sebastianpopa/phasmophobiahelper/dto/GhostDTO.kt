package com.sebastianpopa.phasmophobiahelper.dto

import com.sebastianpopa.phasmophobiahelper.entity.EvidenceType
import java.util.*

data class GhostDTO(
    val id: UUID = UUID.randomUUID(),
    val ghostName: String,
    val canAccelerate: Boolean,
    val evidences: Set<EvidenceType>,
    val details: Set<DetailDTO>
)