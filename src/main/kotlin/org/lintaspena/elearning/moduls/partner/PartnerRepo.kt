package org.lintaspena.elearning.moduls.partner

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PartnerRepo : JpaRepository<Partner, Long>