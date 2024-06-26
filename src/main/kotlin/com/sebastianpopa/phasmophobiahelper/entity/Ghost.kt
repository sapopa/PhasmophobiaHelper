package com.sebastianpopa.phasmophobiahelper.entity

import jakarta.persistence.*
import java.util.*

@Entity
class Ghost(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(unique = true, nullable = false)
    var ghostName: String,
    var canAccelerate: Boolean,
    @ElementCollection(targetClass = EvidenceType::class, fetch = FetchType.EAGER)
    @Enumerated
    var evidences: Set<EvidenceType>,
    @OneToMany
    var details: Set<Detail>
)