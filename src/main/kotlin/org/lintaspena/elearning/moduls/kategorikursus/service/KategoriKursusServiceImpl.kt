package org.lintaspena.elearning.moduls.kategorikursus.service

import org.lintaspena.elearning.moduls.kategorikursus.KategoriKursus
import org.lintaspena.elearning.moduls.kategorikursus.KategoriKursusRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class KategoriKursusServiceImpl: BaseService<KategoriKursus>(), KategoriKursusService {

    @Autowired
    private lateinit var kategoriKursusRepo: KategoriKursusRepo

    override val repo: JpaRepository<KategoriKursus, Long>
        get() = kategoriKursusRepo

    override fun saveKategoriKursus(kategoriKursus: KategoriKursus): KategoriKursus {
        return saveDb(kategoriKursus)
    }

    override fun viewAllKategoriKursus(): List<KategoriKursus> {
        return kategoriKursusRepo.findAll().asSequence().toList()
    }

    override fun findKategoriKursusById(kategoriKursusId: Long): KategoriKursus {
        return  kategoriKursusRepo.findByIdOrNull(kategoriKursusId)!!
    }

    override fun deleteKategoriKursusById(kategoriKursusId: Long) {
        return kategoriKursusRepo.deleteById(kategoriKursusId)
    }
}