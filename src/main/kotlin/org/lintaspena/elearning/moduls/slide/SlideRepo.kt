package org.lintaspena.elearning.moduls.slide

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SlideRepo : JpaRepository<Slide, Long>