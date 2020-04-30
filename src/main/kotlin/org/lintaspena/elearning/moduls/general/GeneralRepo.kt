package org.lintaspena.elearning.moduls.general

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GeneralRepo : JpaRepository<General, Long>