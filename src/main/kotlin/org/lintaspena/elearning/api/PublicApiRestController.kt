package org.lintaspena.elearning.api

import org.apache.logging.log4j.LogManager
import org.lintaspena.elearning.moduls.bantuan.Bantuan
import org.lintaspena.elearning.moduls.bantuan.service.BantuanService
import org.lintaspena.elearning.moduls.general.General
import org.lintaspena.elearning.moduls.general.service.GeneralService
import org.lintaspena.elearning.moduls.kategorikursus.KategoriKursus
import org.lintaspena.elearning.moduls.kategorikursus.service.KategoriKursusService
import org.lintaspena.elearning.moduls.partner.Partner
import org.lintaspena.elearning.moduls.partner.service.PartnerService
import org.lintaspena.elearning.moduls.slide.Slide
import org.lintaspena.elearning.moduls.slide.service.SlideService
import org.lintaspena.elearning.utils.base.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/public")
class PublicApiRestController: BaseController() {

    val logger = LogManager.getLogger(PublicApiRestController::class.java)


    // -- Rest API Bantuan
    @Autowired
    private lateinit var bantuanService: BantuanService

    @GetMapping("/bantuan/all")
    fun getViewAllBantuan(): List<Bantuan> = bantuanService.viewAllBantuan()

    @GetMapping("/bantuan/findById")
    fun getBantuanById(@RequestParam("idBantuan") id : Long): Bantuan {
        return bantuanService.findBantuanById(id)
    }

    // -- Rest API General
    @Autowired
    private lateinit var generalService: GeneralService

    @GetMapping("/general/all")
    fun getViewAllGeneral(): List<General> = generalService.viewAllGeneral()

    @GetMapping("/general/findById")
    fun getGeneralById(@RequestParam("idGeneral") id: Long): General {
        return generalService.findGeneralById(id)
    }

    // -- Rest API Slide
    @Autowired
    private lateinit var slideService: SlideService

    @GetMapping("/slide/all")
    fun getViewAllSlide(): List<Slide> = slideService.viewAllSlide()

    @GetMapping("/slide/findById")
    fun getSlideById(@RequestParam("idSlide") id: Long): Slide{
        return slideService.findSlideById(id)
    }

    // -- Rest API Kategori Kursus
    @Autowired
    private lateinit var kategoriKursusService: KategoriKursusService

    @GetMapping("/kategorikursus/all")
    fun getViewAllKategoriKursus(): List<KategoriKursus> = kategoriKursusService.viewAllKategoriKursus()

    @GetMapping("/kategorikursus/findById")
    fun getKategoriKursusById(@RequestParam("idKategoriKursus") id: Long): KategoriKursus{
        return kategoriKursusService.findKategoriKursusById(id)
    }

    // -- Rest API Partner
    @Autowired
    private lateinit var partnerService: PartnerService

    @GetMapping("/partner/all")
    fun getViewAllPartner(): List<Partner> = partnerService.viewAllPartner()

    @GetMapping("/partner/findById")
    fun getPartnerById(@RequestParam("idPartner") id: Long): Partner{
        return partnerService.findPartnerById(id)
    }

}