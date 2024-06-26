package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Ghost

interface GhostService {
    fun getAllGhosts(): List<Ghost?>
    fun getGhostByName(name: String): Ghost?
}