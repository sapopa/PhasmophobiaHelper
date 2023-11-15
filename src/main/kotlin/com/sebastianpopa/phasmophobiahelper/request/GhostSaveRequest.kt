package com.sebastianpopa.phasmophobiahelper.request

import com.sebastianpopa.phasmophobiahelper.entity.Evidence

data class GhostSaveRequest(
    var name: String,
    var defaultSpeed : Double,
    var minimumSpeed : Double,
    var maximumSpeed : Double,
    var canAccelerate : Boolean,
    var canChangeFavoriteRoom: Boolean,
    var huntSanityThreshold : Short,
    var firstEvidence : Evidence,
    var secondEvidence : Evidence,
    var thirdEvidence : Evidence
)
