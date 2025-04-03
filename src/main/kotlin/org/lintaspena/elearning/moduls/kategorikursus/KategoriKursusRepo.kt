package org.lintaspena.elearning.moduls.kategorikursus

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KategoriKursusRepo : JpaRepository<KategoriKursus, Long>