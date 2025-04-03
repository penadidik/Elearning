package org.lintaspena.elearning.moduls.testimoni

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestimoniRepo : JpaRepository<Testimoni, Long>