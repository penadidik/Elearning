package org.lintaspena.elearning.moduls.materi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MateriRepo : JpaRepository<Materi, Long>