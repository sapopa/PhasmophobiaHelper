package com.sebastianpopa.phasmophobiahelper.repository

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GhostRepository : JpaRepository<Ghost?, UUID> {
    fun findByGhostName(ghostName: String) : Ghost?
}