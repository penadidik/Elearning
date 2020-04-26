package org.lintaspena.elearning.moduls.general.service

import org.lintaspena.elearning.moduls.general.General

interface GeneralService {

    fun saveGeneral(general: General): General

    fun viewAllGeneral(): List<General>

    fun findGeneralById(generalId: Long): General

    fun deleteGeneral(generalId: Long)

}