package com.sebastianpopa.phasmophobiahelper.controller

import com.sebastianpopa.phasmophobiahelper.dao.GhostDAO
import com.sebastianpopa.phasmophobiahelper.dto.GhostDTO
import com.sebastianpopa.phasmophobiahelper.extensions.toDto
import com.sebastianpopa.phasmophobiahelper.response.DeleteGhostResponse
import com.sebastianpopa.phasmophobiahelper.service.GhostService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
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

    @MutationMapping
    fun addGhost(@Argument(name = "ghostInput") ghostDAO: GhostDAO): GhostDTO? {
        return ghostService.addGhost(ghostDAO)?.toDto()
    }

    @MutationMapping
    fun removeGhost(@Argument ghostName: String): DeleteGhostResponse {
        val deletedGhost = ghostService.removeGhost(ghostName)?.toDto()
        if(deletedGhost != null){
            return DeleteGhostResponse(success = true, message = "You have removed $ghostName from the database successfully!", deletedGhost = deletedGhost)
        }
        return DeleteGhostResponse(success = false, message = "$ghostName was not removed from the database. Perhaps the ghost name is wrong?")
    }

    @MutationMapping
    fun updateGhost(@Argument ghostName: String, @Argument(name = "ghost") ghostDAO: GhostDAO): GhostDTO? {
        return ghostService.updateGhost(ghostName, ghostDAO)?.toDto()
    }
}