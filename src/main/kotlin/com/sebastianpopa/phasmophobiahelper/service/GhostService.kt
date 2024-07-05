package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.dao.GhostDAO
import com.sebastianpopa.phasmophobiahelper.entity.Ghost

interface GhostService {
    fun getAllGhosts(): List<Ghost?>
    fun getGhostByName(ghostName: String): Ghost?
    fun addGhost(ghostDAO: GhostDAO): Ghost?
    fun removeGhost(ghostName: String): Ghost?
    fun updateGhost(ghostName: String, ghostDAO: GhostDAO): Ghost?
}