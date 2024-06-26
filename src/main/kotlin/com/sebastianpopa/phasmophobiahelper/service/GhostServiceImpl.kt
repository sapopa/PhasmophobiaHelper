package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Detail
import com.sebastianpopa.phasmophobiahelper.entity.EvidenceType
import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.entity.InformationType
import org.springframework.stereotype.Service

@Service
class GhostServiceImpl: GhostService{
    val mockData = listOf(
        Ghost(ghostName = "Yokai", canAccelerate = true,
            evidences = setOf(EvidenceType.DOTS_PROJECTOR, EvidenceType.GHOST_ORB, EvidenceType.SPIRIT_BOX),
            details = setOf(Detail(summary = "This ghost will always know your location!", information = InformationType.STRENGTH), Detail(summary = "This ghost will walk slower the closer it is to you!", information = InformationType.WEAKNESS))),
        Ghost(ghostName = "Yurei", canAccelerate = false,
            evidences = setOf(EvidenceType.DOTS_PROJECTOR, EvidenceType.GHOST_ORB, EvidenceType.FREEZING_TEMPERATURES),
            details = setOf(Detail(summary = "This ghost cannot turn off the breaker!", information = InformationType.WEAKNESS), Detail(summary = "This ghost will walk faster near electronics!", information = InformationType.NEUTRAL)))
    )
    override fun getAllGhosts(): List<Ghost?> {
        return mockData
    }

    override fun getGhostByName(name: String): Ghost? {
        return mockData.find { it.ghostName == name }
    }
}