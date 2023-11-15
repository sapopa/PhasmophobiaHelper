package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Evidence

interface EvidenceService {
    fun findEvidenceByName(name : String) : Evidence?
    fun findAllEvidences() : List<Evidence>
    fun addEvidence(evidence: Evidence) : Evidence
}