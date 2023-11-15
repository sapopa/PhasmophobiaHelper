package com.sebastianpopa.phasmophobiahelper.controller

import com.sebastianpopa.phasmophobiahelper.entity.Ghost
import com.sebastianpopa.phasmophobiahelper.service.GhostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ghosts")
class GhostController(private val ghostService: GhostService) {
    @GetMapping("/{name}")
    fun getGhostByName(@PathVariable name: String): ResponseEntity<Ghost> {
        val ghost = ghostService.findGhostByName(name)
        ghost?.let {
            return ResponseEntity.ok(it)
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAllGhosts(): List<Ghost> {
        return ghostService.findAllGhosts()
    }

    @PostMapping
    fun addGhost(@RequestBody ghost: Ghost): ResponseEntity<Ghost> {
        val ghostToAdd = ghostService.addGhost(ghost)
        return ResponseEntity.status(HttpStatus.CREATED).body(ghostToAdd)
    }
}