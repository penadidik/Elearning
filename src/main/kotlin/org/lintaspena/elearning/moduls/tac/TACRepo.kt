package org.lintaspena.elearning.moduls.tac

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TACRepo : JpaRepository<TAC, Long>