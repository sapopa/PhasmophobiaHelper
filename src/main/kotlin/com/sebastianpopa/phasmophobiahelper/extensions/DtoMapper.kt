package com.sebastianpopa.phasmophobiahelper.extensions

import com.sebastianpopa.phasmophobiahelper.dto.DetailDTO
import com.sebastianpopa.phasmophobiahelper.dto.GhostDTO
import com.sebastianpopa.phasmophobiahelper.entity.Detail
import com.sebastianpopa.phasmophobiahelper.entity.Ghost

fun Ghost.toDto(): GhostDTO = GhostDTO(
    ghostName = ghostName,
    canAccelerate = canAccelerate,
    evidences = evidences,
    details = details.map { it.toDto() }.toSet()
)

fun Detail.toDto(): DetailDTO = DetailDTO(summary = summary, information = information)