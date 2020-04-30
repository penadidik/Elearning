package org.lintaspena.elearning.moduls.bantuan

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BantuanRepo : JpaRepository<Bantuan, Long>