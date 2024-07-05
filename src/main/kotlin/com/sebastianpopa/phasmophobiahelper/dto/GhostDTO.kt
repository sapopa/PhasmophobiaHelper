package com.sebastianpopa.phasmophobiahelper.dto

import com.sebastianpopa.phasmophobiahelper.entity.EvidenceType

data class GhostDTO(
    val ghostName: String,
    val canAccelerate: Boolean,
    val evidences: Set<EvidenceType>,
    val details: Set<DetailDTO>
)