package org.lintaspena.elearning.moduls.bantuan.service

import org.lintaspena.elearning.moduls.bantuan.Bantuan
import org.lintaspena.elearning.moduls.bantuan.BantuanRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class BantuanServiceImpl : BaseService<Bantuan>(), BantuanService {

    @Autowired
    private lateinit var bantuanRepo: BantuanRepo

    override val repo: JpaRepository<Bantuan, Long>
        get() = bantuanRepo

    override fun saveBantuan(bantuan: Bantuan): Bantuan {
        return saveDb(bantuan)
    }

    override fun viewAllBantuan(): List<Bantuan> {
        return bantuanRepo.findAll().asSequence().toList()
    }

    override fun findBantuanById(bantuanId: Long): Bantuan {
        return bantuanRepo.findByIdOrNull(bantuanId)!!
    }

    override fun deleteBantuan(bantuanId: Long) {
        return bantuanRepo.deleteById(bantuanId)
    }

}