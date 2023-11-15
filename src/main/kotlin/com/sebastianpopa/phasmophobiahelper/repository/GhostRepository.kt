package com.sebastianpopa.phasmophobiahelper.repository

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GhostRepository : JpaRepository<Ghost, UUID> {
    fun findByName(name: String): Ghost?
}