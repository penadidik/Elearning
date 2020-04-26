package org.lintaspena.elearning.features

import org.lintaspena.elearning.utils.base.BaseController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class Dashboard: BaseController() {

    @RequestMapping("/")
    override fun initControl(): String {
        return "public/fragments/beranda"
    }

    @RequestMapping("/tentang")
    fun tentang(): String {
        return "public/fragments/tentang"
    }

    @RequestMapping("/kursus")
    fun kursus(): String {
        return "public/fragments/kursus"
    }

    @RequestMapping("/kontak")
    fun kontak(): String {
        return "public/fragments/kontak"
    }

    @RequestMapping("/login")
    fun login(): String {
        return "public/fragments/login"
    }

}