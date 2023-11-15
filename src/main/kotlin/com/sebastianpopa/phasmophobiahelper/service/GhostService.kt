package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Ghost

interface GhostService {
    fun findAllGhosts() : List<Ghost>
    fun findGhostByName(ghostName : String) : Ghost?
    fun addGhost(ghost: Ghost) : Ghost
}