package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.repository.EvidenceRepository
import com.sebastianpopa.phasmophobiahelper.repository.GhostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GhostServiceImpl(private val ghostRepository: GhostRepository, private val evidenceRepository: EvidenceRepository) : GhostService {
    override fun findAllGhosts(): List<Ghost> {
        return ghostRepository.findAll()
    }

    override fun findGhostByName(ghostName: String): Ghost? {
        return ghostRepository.findByName(ghostName)
    }

    @Transactional
    override fun addGhost(ghost: Ghost): Ghost {
        val firstEvidence = evidenceRepository.findByName(ghost.firstEvidence.name)
        val secondEvidence = evidenceRepository.findByName(ghost.secondEvidence.name)
        val thirdEvidence = evidenceRepository.findByName(ghost.thirdEvidence.name)
        ghost.firstEvidence = firstEvidence ?: ghost.firstEvidence
        ghost.secondEvidence = secondEvidence ?: ghost.secondEvidence
        ghost.thirdEvidence = thirdEvidence ?: ghost.thirdEvidence
        return ghostRepository.save(ghost)
    }
}