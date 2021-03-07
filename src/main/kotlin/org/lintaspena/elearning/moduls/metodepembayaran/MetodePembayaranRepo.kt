package org.lintaspena.elearning.moduls.metodepembayaran

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MetodePembayaranRepo : JpaRepository<MetodePembayaran, Long>