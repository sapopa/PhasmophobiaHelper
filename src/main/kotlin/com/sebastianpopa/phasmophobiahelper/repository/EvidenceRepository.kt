package com.sebastianpopa.phasmophobiahelper.repository

import com.sebastianpopa.phasmophobiahelper.entity.Evidence
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EvidenceRepository : JpaRepository<Evidence, UUID> {
    fun findByName(name : String) : Evidence?
}