package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.dao.GhostDAO
import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.extensions.convertToEntity
import com.sebastianpopa.phasmophobiahelper.extensions.toEntity
import com.sebastianpopa.phasmophobiahelper.repository.GhostRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class GhostServiceImpl(private val ghostRepository: GhostRepository): GhostService{
    override fun getAllGhosts(): List<Ghost?> = ghostRepository.findAll()

    override fun getGhostByName(ghostName: String): Ghost? = ghostRepository.findByGhostName(ghostName)

    @Transactional
    override fun addGhost(ghostDAO: GhostDAO): Ghost? {
        val ghost = convertToEntity(ghostDAO) ?: return null
        return ghostRepository.save(ghost)
    }

    @Transactional
    override fun removeGhost(ghostName: String) : Ghost? {
        val ghost = getGhostByName(ghostName)
        if(ghost != null){
            ghostRepository.delete(ghost)
        }
        return ghost
    }

    @Transactional
    override fun updateGhost(ghostName: String, ghostDAO: GhostDAO): Ghost? {
        val ghost = getGhostByName(ghostName)
        ghost?.let {
            it.ghostName = ghostDAO.ghostName ?: it.ghostName
            it.evidences = ghostDAO.evidences ?: it.evidences
            it.details = ghostDAO.details?.map { detailDAO ->
                detailDAO.toEntity(it) }?.toSet() ?: it.details
            it.canAccelerate = ghostDAO.canAccelerate ?: it.canAccelerate
        }
        return ghost
    }
}