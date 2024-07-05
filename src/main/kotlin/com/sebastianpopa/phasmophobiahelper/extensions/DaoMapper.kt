package com.sebastianpopa.phasmophobiahelper.extensions

import com.sebastianpopa.phasmophobiahelper.dao.DetailDAO
import com.sebastianpopa.phasmophobiahelper.dao.GhostDAO
import com.sebastianpopa.phasmophobiahelper.entity.Detail
import com.sebastianpopa.phasmophobiahelper.entity.Ghost

fun DetailDAO.toEntity(ghost: Ghost): Detail {
    return Detail(summary = summary, information = information, ghost = ghost)
}

fun GhostDAO.toEntity(): Ghost? {
    if(ghostName == null || canAccelerate == null || evidences == null){
        return null
    }
    return Ghost(ghostName = ghostName, details = emptySet() , canAccelerate = canAccelerate, evidences = evidences)
}

fun convertToEntity(ghostDAO: GhostDAO) : Ghost?  {
    val ghost = ghostDAO.toEntity() ?: return null
    val details = ghostDAO.details?.map { it.toEntity(ghost) }?.toSet() ?: emptySet()
    ghost.details = details
    return ghost
}