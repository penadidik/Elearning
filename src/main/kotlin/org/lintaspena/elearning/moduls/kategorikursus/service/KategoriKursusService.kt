package org.lintaspena.elearning.moduls.kategorikursus.service

import org.lintaspena.elearning.moduls.kategorikursus.KategoriKursus

interface KategoriKursusService {

    fun saveKategoriKursus(kategoriKursus: KategoriKursus): KategoriKursus

    fun viewAllKategoriKursus(): List<KategoriKursus>

    fun findKategoriKursusById(kategoriKursusId: Long): KategoriKursus

    fun deleteKategoriKursusById(kategoriKursusId: Long)

}