package com.sebastianpopa.phasmophobiahelper.repository

import com.sebastianpopa.phasmophobiahelper.entity.Detail
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DetailRepository: JpaRepository<Detail?, UUID>