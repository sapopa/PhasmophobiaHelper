package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Evidence
import com.sebastianpopa.phasmophobiahelper.repository.EvidenceRepository
import org.springframework.stereotype.Service

@Service
class EvidenceServiceImpl(private val evidenceRepository : EvidenceRepository) : EvidenceService {
    override fun findEvidenceByName(name: String): Evidence? {
        return evidenceRepository.findByName(name)
    }

    override fun findAllEvidences(): List<Evidence> {
        return evidenceRepository.findAll()
    }

    override fun addEvidence(evidence : Evidence) : Evidence {
        return evidenceRepository.save(evidence)
    }
}