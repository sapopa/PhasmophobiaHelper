package com.sebastianpopa.phasmophobiahelper.controller

import com.sebastianpopa.phasmophobiahelper.entity.Evidence
import com.sebastianpopa.phasmophobiahelper.service.EvidenceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evidences")
class EvidenceController(private val evidenceService: EvidenceService) {
    @GetMapping("/{name}")
    fun getEvidence(@PathVariable name : String) : ResponseEntity<Evidence> {
        val evidence = evidenceService.findEvidenceByName(name)
        evidence?.let {
            return ResponseEntity.ok(it)
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAllEvidences() : List<Evidence> {
        return evidenceService.findAllEvidences()
    }

    @PostMapping
    fun addEvidence(@RequestBody evidence : Evidence) : ResponseEntity<Evidence> {
        val evidenceToAdd = evidenceService.addEvidence(evidence)
        return ResponseEntity.status(HttpStatus.CREATED).body(evidenceToAdd)
    }
}