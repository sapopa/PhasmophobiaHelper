package com.sebastianpopa.phasmophobiahelper.response

import com.sebastianpopa.phasmophobiahelper.dto.GhostDTO

data class DeleteGhostResponse(val success: Boolean, val message: String, val deletedGhost: GhostDTO? = null)
