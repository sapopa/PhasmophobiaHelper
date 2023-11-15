package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.entity.Information
import com.sebastianpopa.phasmophobiahelper.repository.GhostRepository
import com.sebastianpopa.phasmophobiahelper.repository.InformationRepository
import com.sebastianpopa.phasmophobiahelper.request.InformationSaveRequest
import org.springframework.stereotype.Service

@Service
class InformationServiceImpl(private val informationRepository: InformationRepository, private val ghostRepository: GhostRepository) : InformationService {

    override fun findAllInformation(): List<Information> {
        return informationRepository.findAll()
    }
    override fun findAllInformationByGhostName(ghostName: String): List<Information> {
        val ghost = getGhost(ghostName)
        ghost?.let {
            return informationRepository.findAllByGhost(ghost)
        }
        return emptyList()
    }

    override fun findAllInformationByGhostNameAndStrength(ghostName: String, isStrength: Boolean): List<Information> {
        val ghost = getGhost(ghostName)
        ghost?.let {
            return informationRepository.findAllByGhostAndIsStrength(ghost, isStrength)
        }
        return emptyList()
    }

    override fun findAllInformationByGhostNameAndUniqueBehaviour(ghostName: String, isUniqueBehaviour: Boolean): List<Information> {
        val ghost = getGhost(ghostName)
        ghost?.let {
            return informationRepository.findAllByGhostAndIsUniqueBehaviour(ghost, isUniqueBehaviour)
        }
        return emptyList()
    }

    override fun addInformationForGhost(information: InformationSaveRequest) : Information? {
        val ghost = getGhost(information.ghostName)
        ghost?.let {
            val informationToAdd = Information(information.description, information.isStrength, information.isUniqueBehaviour, ghost)
            return informationRepository.save(informationToAdd)
        }
        return null
    }

    private fun getGhost(ghostName: String) : Ghost? {
        return ghostRepository.findByName(ghostName)
    }
}