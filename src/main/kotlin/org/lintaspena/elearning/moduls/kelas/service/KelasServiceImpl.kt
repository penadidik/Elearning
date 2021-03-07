package org.lintaspena.elearning.moduls.kelas.service

import org.lintaspena.elearning.moduls.kelas.Kelas
import org.lintaspena.elearning.moduls.kelas.KelasRepo
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
open class KelasServiceImpl: BaseService<Kelas>(), KelasService  {

    @Autowired
    private lateinit var kelasRepo: KelasRepo

    override val repo: JpaRepository<Kelas, Long>
        get() = kelasRepo

    @PersistenceContext
    private lateinit var em: EntityManager

    override fun saveKelas(kelas: Kelas): Kelas {
        return saveDb(kelas)
    }

    override fun viewAllKelas(): List<Kelas> {
        return kelasRepo.findAll().asSequence().toList()
    }

    override fun findKelasById(kelasId: Long): Kelas {
        return kelasRepo.findByIdOrNull(kelasId)!!
    }

    override fun deleteKelasById(kelasId: Long) {
        return kelasRepo.deleteById(kelasId)
    }

    override fun viewAllKelas(limit: Int): List<Map<String, Any>> {
        var queryLimit = ""
        if(limit!=0){queryLimit = "LIMIT $limit"}else{queryLimit = ""}
        val queryStr = "SELECT \n" +
                "a.id AS idKelas, a.nama_kelas AS namaKelas, a.deskripsi_kelas AS deskripsiKelas, a.jumlah_materi AS jumlahMateri, a.harga_kelas AS hargaKelas, a.photo_kelas as photoKelas,\n" +
                "b.id AS idKategori, b.nama_kategori AS namaKategori, c.fullname AS pemateri\n" +
                "FROM tb_m_kelas a\n" +
                "LEFT JOIN tb_m_kategori_kursus b ON b.id=a.id_kategori\n" +
                "LEFT JOIN tb_m_user c ON c.id=a.id_pemateri "+queryLimit
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id","namaKelas","deskripsiKelas","jumlahMateri","hargaKelas","photoKelas","idKategori","namaKategori","pemateri"))!!
    }

    override fun viewAllKelasTerbaru(limit: Int): List<Map<String, Any>> {
        var queryLimit = ""
        if(limit!=0){queryLimit = "LIMIT $limit"}else{queryLimit = ""}
        val queryStr = "SELECT \n" +
                "a.id AS idKelas, a.nama_kelas AS namaKelas, a.deskripsi_kelas AS deskripsiKelas, a.jumlah_materi AS jumlahMateri, a.harga_kelas AS hargaKelas, a.photo_kelas as photoKelas,\n" +
                "b.id AS idKategori, b.nama_kategori AS namaKategori, c.fullname AS pemateri\n" +
                "FROM tb_m_kelas a\n" +
                "LEFT JOIN tb_m_kategori_kursus b ON b.id=a.id_kategori\n" +
                "LEFT JOIN tb_m_user c ON c.id=a.id_pemateri\n" +
                "ORDER BY a.created_date DESC $queryLimit"
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id","namaKelas","deskripsiKelas","jumlahMateri","hargaKelas","photoKelas","idKategori","namaKategori","pemateri"))!!
    }

    override fun viewAllKelasBestSeller(limit: Int): List<Map<String, Any>> {
        var queryLimit = ""
        if(limit!=0){queryLimit = "LIMIT $limit"}else{queryLimit = ""}
        val queryStr = "SELECT \n" +
                "a.id AS idKelas, a.nama_kelas AS namaKelas, a.deskripsi_kelas AS deskripsiKelas, a.jumlah_materi AS jumlahMateri, a.harga_kelas AS hargaKelas, a.photo_kelas as photoKelas,\n" +
                "b.id AS idKategori, b.nama_kategori AS namaKategori, c.fullname AS pemateri ,(SELECT COUNT(*) FROM tb_m_transaksi d WHERE d.id_kelas=a.id) AS countKelas\n" +
                "FROM tb_m_kelas a\n" +
                "LEFT JOIN tb_m_kategori_kursus b ON b.id=a.id_kategori\n" +
                "LEFT JOIN tb_m_user c ON c.id=a.id_pemateri\n" +
                "WHERE (SELECT COUNT(*) FROM tb_m_transaksi d WHERE d.id_kelas=a.id)>=2\n" +
                "ORDER BY countKelas DESC $queryLimit"
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id","namaKelas","deskripsiKelas","jumlahMateri","hargaKelas","photoKelas","idKategori","namaKategori","pemateri","countKelas"))!!
    }
}