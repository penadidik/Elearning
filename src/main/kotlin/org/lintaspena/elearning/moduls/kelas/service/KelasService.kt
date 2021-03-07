package org.lintaspena.elearning.moduls.kelas.service

import org.lintaspena.elearning.moduls.kelas.Kelas

interface KelasService {

    fun saveKelas(kelas: Kelas): Kelas

    fun viewAllKelas():List<Kelas>

    fun findKelasById(kelasId: Long): Kelas

    fun deleteKelasById(kelasId: Long)

    fun viewAllKelas(limit: Int): List<Map<String, Any>>

    fun viewAllKelasTerbaru(limit: Int): List<Map<String, Any>>

    fun viewAllKelasBestSeller(limit: Int): List<Map<String, Any>>

}