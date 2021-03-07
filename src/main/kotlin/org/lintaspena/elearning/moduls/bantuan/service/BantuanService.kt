package org.lintaspena.elearning.moduls.bantuan.service

import org.lintaspena.elearning.moduls.bantuan.Bantuan

interface BantuanService {

    fun saveBantuan(bantuan: Bantuan): Bantuan

    fun viewAllBantuan(): List<Bantuan>

    fun findBantuanById(bantuanId: Long): Bantuan

    fun deleteBantuan(bantuanId: Long)

}