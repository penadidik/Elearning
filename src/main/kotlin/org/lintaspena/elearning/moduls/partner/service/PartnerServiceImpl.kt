package org.lintaspena.elearning.moduls.partner.service

import org.lintaspena.elearning.moduls.partner.Partner
import org.lintaspena.elearning.moduls.partner.PartnerRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class PartnerServiceImpl: BaseService<Partner>(), PartnerService {

    @Autowired
    private lateinit var partnerRepo: PartnerRepo

    override val repo: JpaRepository<Partner, Long>
        get() = partnerRepo

    override fun savePartner(partner: Partner): Partner {
        return saveDb(partner)
    }

    override fun viewAllPartner(): List<Partner> {
        return partnerRepo.findAll().asSequence().toList()
    }

    override fun findPartnerById(partnerId: Long): Partner {
        return partnerRepo.findByIdOrNull(partnerId)!!
    }

    override fun deletePartnerById(partnerId: Long) {
        return partnerRepo.deleteById(partnerId)
    }
}