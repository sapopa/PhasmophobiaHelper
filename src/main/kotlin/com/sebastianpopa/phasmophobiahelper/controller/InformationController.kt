package com.sebastianpopa.phasmophobiahelper.controller

import com.sebastianpopa.phasmophobiahelper.entity.Information
import com.sebastianpopa.phasmophobiahelper.request.InformationRequest
import com.sebastianpopa.phasmophobiahelper.request.InformationSaveRequest
import com.sebastianpopa.phasmophobiahelper.service.InformationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/information")
class InformationController(private val informationService: InformationService) {
    @GetMapping
    fun findAllInformation() : List<Information> {
        return informationService.findAllInformation()
    }

    @GetMapping("/ghost/{ghostName}")
    fun findAllInformationByGhostName(@PathVariable ghostName : String) : List<Information>{
        return informationService.findAllInformationByGhostName(ghostName)
    }

    @GetMapping("/ghostByStrength")
    fun findAllInformationByGhostNameAndStrength(@RequestBody information : InformationRequest) : List<Information>{
        return informationService.findAllInformationByGhostNameAndStrength(information.ghostName, information.isStrength)
    }

    @GetMapping("/ghostByUniqueBehaviour")
    fun findAllInformationByGhostNameAndUniqueBehaviour(@RequestBody information : InformationRequest) : List<Information>{
        return informationService.findAllInformationByGhostNameAndUniqueBehaviour(information.ghostName, information.isUniqueBehaviour)
    }

    @PostMapping("/ghost")
    fun addInformationForGhost(@RequestBody information: InformationSaveRequest) : ResponseEntity<*>{
        val informationToAdd = informationService.addInformationForGhost(information)
        informationToAdd?.let {
            return ResponseEntity.status(HttpStatus.CREATED).body(it)
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ghost not found for the information to be added!")
    }
}