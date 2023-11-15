package com.sebastianpopa.phasmophobiahelper.service

import com.sebastianpopa.phasmophobiahelper.entity.Information
import com.sebastianpopa.phasmophobiahelper.request.InformationSaveRequest

interface InformationService {
    fun findAllInformation() : List<Information>
    fun findAllInformationByGhostName(ghostName: String) : List<Information>
    fun findAllInformationByGhostNameAndStrength(ghostName : String, isStrength: Boolean) : List<Information>
    fun findAllInformationByGhostNameAndUniqueBehaviour(ghostName : String, isUniqueBehaviour: Boolean) : List<Information>
    fun addInformationForGhost(information: InformationSaveRequest) : Information?
}