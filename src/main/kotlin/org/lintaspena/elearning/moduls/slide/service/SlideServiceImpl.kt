package org.lintaspena.elearning.moduls.slide.service

import org.lintaspena.elearning.moduls.slide.Slide
import org.lintaspena.elearning.moduls.slide.SlideRepo
import org.lintaspena.elearning.utils.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class SlideServiceImpl: BaseService<Slide>(), SlideService {

    @Autowired
    private lateinit var slideRepo: SlideRepo

    override val repo: JpaRepository<Slide, Long>
        get() = slideRepo

    override fun saveSlide(slide: Slide): Slide {
        return saveDb(slide)
    }

    override fun viewAllSlide(): List<Slide> {
        return slideRepo.findAll().asSequence().toList()
    }

    override fun findSlideById(slideId: Long): Slide {
        return slideRepo.findByIdOrNull(slideId)!!
    }

    override fun deleteSlideById(slideId: Long) {
        return slideRepo.deleteById(slideId)
    }
}