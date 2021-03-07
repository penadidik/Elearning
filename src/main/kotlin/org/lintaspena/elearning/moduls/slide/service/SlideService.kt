package org.lintaspena.elearning.moduls.slide.service

import org.lintaspena.elearning.moduls.slide.Slide

interface SlideService {

    fun saveSlide(slide: Slide): Slide

    fun viewAllSlide(): List<Slide>

    fun findSlideById(slideId: Long): Slide

    fun deleteSlideById(slideId: Long)

}