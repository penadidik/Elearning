package org.lintaspena.elearning.moduls.transaksi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransaksiRepo : JpaRepository<Transaksi, Long>