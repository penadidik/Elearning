package org.lintaspena.elearning.moduls.general.service

import org.lintaspena.elearning.moduls.general.General
import org.lintaspena.elearning.moduls.general.GeneralRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class GeneralServiceImpl: BaseService<General>(), GeneralService {

    @Autowired
    private lateinit var generalRepo: GeneralRepo

    override val repo: JpaRepository<General, Long>
        get() = generalRepo

    override fun saveGeneral(general: General): General {
        return saveDb(general)
    }

    override fun viewAllGeneral(): List<General> {
        return generalRepo.findAll().asSequence().toList()
    }

    override fun findGeneralById(generalId: Long): General {
        return generalRepo.findByIdOrNull(generalId)!!
    }

    override fun deleteGeneral(generalId: Long) {
        return generalRepo.deleteById(generalId)
    }
}