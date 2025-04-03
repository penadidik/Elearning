package org.lintaspena.elearning.moduls.karir

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KarirRepo : JpaRepository<Karir,Long>