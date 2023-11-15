package com.sebastianpopa.phasmophobiahelper.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["evidence1_id", "evidence2_id", "evidence3_id"])
    ])
class Ghost(
    @JsonIgnore
    @Id
    val id : UUID = UUID.randomUUID(),
    @NotNull
    @NotBlank
    @Column(unique = true)
    var name: String,
    @OneToMany(
        mappedBy = "ghost",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var information: MutableList<Information>,
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    var defaultSpeed : Double,
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    var minimumSpeed : Double,
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    var maximumSpeed : Double,
    var canAccelerate : Boolean,
    var canChangeFavoriteRoom: Boolean,
    @Min(value = 0)
    @Max(value = 100)
    var huntSanityThreshold : Short,
    @ManyToOne
    @JoinColumn(name = "evidence1_id")
    var firstEvidence : Evidence,
    @ManyToOne
    @JoinColumn(name = "evidence2_id")
    var secondEvidence : Evidence,
    @ManyToOne
    @JoinColumn(name = "evidence3_id")
    var thirdEvidence : Evidence,
)