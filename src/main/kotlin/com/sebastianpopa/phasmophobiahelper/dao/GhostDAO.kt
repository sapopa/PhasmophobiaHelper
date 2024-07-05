package com.sebastianpopa.phasmophobiahelper.dao

import com.sebastianpopa.phasmophobiahelper.entity.EvidenceType

data class GhostDAO(val ghostName: String?,
                    val canAccelerate: Boolean?,
                    val evidences: Set<EvidenceType>?,
                    val details: Set<DetailDAO>?)
