package org.lintaspena.elearning.moduls.kelas

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KelasRepo : JpaRepository<Kelas, Long>