package org.lintaspena.elearning.moduls.testimoni.service

import org.lintaspena.elearning.moduls.testimoni.Testimoni
import org.lintaspena.elearning.moduls.testimoni.TestimoniRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.lintaspena.elearning.utils.component.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Transactional
@Service
open class TestimoniServiceImpl: BaseService<Testimoni>(), TestimoniService {

    @Autowired
    private lateinit var testimoniRepo: TestimoniRepo

    override val repo: JpaRepository<Testimoni, Long>
        get() = testimoniRepo

    @PersistenceContext
    private lateinit var em: EntityManager

    override fun saveTestimoni(testimoni: Testimoni): Testimoni {
        return saveDb(testimoni)
    }

    override fun viewAllTestimoni(): List<Testimoni> {
        return testimoniRepo.findAll().asSequence().toList()
    }

    override fun findTestimoniById(testimoniId: Long): Testimoni {
        return testimoniRepo.findByIdOrNull(testimoniId)!!
    }

    override fun deleteTestimoniById(testimoniId: Long) {
        return testimoniRepo.deleteById(testimoniId)
    }

    override fun viewAllTestimoniWithKelasAndMember(): List<Map<String, Any>> {
        val queryStr = "SELECT\n" +
                "a.id AS idTestimoni, a.isi_testimoni AS isiTestimoni, a.rating_kelas As ratingKelas,\n" +
                "b.id AS idPeserta, b.fullname AS fullnamePeserta, b.photo AS photoPeserta,\n" +
                "c.id AS idKelas, c.nama_kelas as namaKelas\n" +
                "FROM tb_m_testimoni a\n" +
                "LEFT JOIN tb_m_user b ON b.id=a.id_peserta\n" +
                "LEFT JOIN tb_m_kelas c ON c.id=a.id_kelas ORDER BY a.id DESC LIMIT 3"
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id","isiTestimoni","ratingKelas","idPeserta","fullnamePeserta","photoPeserta","idKelas","namaKelas"))!!
    }
}