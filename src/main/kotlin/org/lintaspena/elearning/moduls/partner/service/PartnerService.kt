package org.lintaspena.elearning.moduls.partner.service

import org.lintaspena.elearning.moduls.partner.Partner

interface PartnerService {

    fun savePartner(partner: Partner): Partner

    fun viewAllPartner(): List<Partner>

    fun findPartnerById(partnerId: Long): Partner

    fun deletePartnerById(partnerId: Long)

}