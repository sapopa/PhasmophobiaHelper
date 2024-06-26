package com.sebastianpopa.phasmophobiahelper.entity

enum class EvidenceType(private val displayName: String) {
    EMF_LEVEL_5("EMF Level 5"),
    ULTRAVIOLET("Ultraviolet"),
    GHOST_WRITING("Ghost Writing"),
    DOTS_PROJECTOR("D.O.T.S Projector"),
    GHOST_ORB("Ghost Orb"),
    SPIRIT_BOX("Spirit Box"),
    FREEZING_TEMPERATURES("Freezing Temperatures");

    override fun toString(): String {
        return displayName
    }
}