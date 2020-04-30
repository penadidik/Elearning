package org.lintaspena.elearning.features

import org.apache.logging.log4j.LogManager
import org.lintaspena.elearning.moduls.userrole.service.UserService
import org.lintaspena.elearning.utils.base.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping

class AkunController: BaseController() {

    val logger = LogManager.getLogger(AkunController::class.java)

    @Autowired
    private lateinit var userService: UserService

    @RequestMapping("/akun")
    fun akun(): String {
        return "public/fragments/akun"
    }

}