package org.lintaspena.elearning.features

import org.apache.logging.log4j.LogManager
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.moduls.userrole.service.UserService
import org.lintaspena.elearning.utils.base.BaseController
import org.lintaspena.elearning.utils.component.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BerandaController: BaseController() {

    val logger = LogManager.getLogger(BerandaController::class.java)

    @Autowired
    private lateinit var userService: UserService

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

    @PostMapping("/registration")
    @ResponseBody
    fun registration(@RequestBody user: String): String {

        val res = Response()
        res.success = false

        try{

            val data = convertResponseToModel(user, "data", User::class.java)
            if(data.password == data.passwordConfirmation) userService.registrationUser(data,"MEMBER")
            res.success = true
            res.message = "Saved"

        }catch (e: Exception){
            log(e, logger)
            res.message = e.toString()
        }

        return responseToString(res)

    }

}