package org.lintaspena.elearning.moduls.testimoni.service

import org.lintaspena.elearning.moduls.testimoni.Testimoni

interface TestimoniService {

    fun saveTestimoni(testimoni: Testimoni): Testimoni

    fun viewAllTestimoni(): List<Testimoni>

    fun findTestimoniById(testimoniId: Long): Testimoni

    fun deleteTestimoniById(testimoniId: Long)

    fun viewAllTestimoniWithKelasAndMember(): List<Map<String, Any>>

}