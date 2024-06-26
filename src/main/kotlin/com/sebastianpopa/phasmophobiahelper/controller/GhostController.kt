package com.sebastianpopa.phasmophobiahelper.controller

import com.sebastianpopa.phasmophobiahelper.dto.GhostDTO
import com.sebastianpopa.phasmophobiahelper.extensions.toDto
import com.sebastianpopa.phasmophobiahelper.service.GhostService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class GhostController(private val ghostService: GhostService) {

    private val logger: Logger = LoggerFactory.getLogger(GhostController::class.java)

    @QueryMapping
    fun getAllGhosts(): List<GhostDTO?>{
        return ghostService.getAllGhosts().map { it?.toDto() }
    }

    @QueryMapping
    fun getGhostByName(@Argument ghostName: String): GhostDTO?{
        logger.info(ghostService.getGhostByName(ghostName)?.evidences?.toString())
        return ghostService.getGhostByName(ghostName)?.toDto()
    }
}