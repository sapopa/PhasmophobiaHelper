package com.sebastianpopa.phasmophobiahelper.repository

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.entity.Information
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InformationRepository : JpaRepository<Information, UUID>{
    fun findAllByGhost(ghost: Ghost) : List<Information>

    fun findAllByGhostAndIsStrength(ghost: Ghost, isStrength : Boolean) : List<Information>

    fun findAllByGhostAndIsUniqueBehaviour(ghost: Ghost, isUniqueBehaviour : Boolean) : List<Information>

}