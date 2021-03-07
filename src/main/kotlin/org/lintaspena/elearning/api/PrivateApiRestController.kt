package org.lintaspena.elearning.api

import org.apache.logging.log4j.LogManager
import org.lintaspena.elearning.utils.component.Constant
import org.lintaspena.elearning.utils.component.SecureController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/private")
class PrivateApiRestController: SecureController() {

    val logger = LogManager.getLogger(PrivateApiRestController::class.java)

    override fun controllClass() = Constant.Controller.api

    override fun initControl() = ""
    
    @GetMapping("/session")
    fun getDataUser(): Map<String, String> {
        val map = HashMap<String, String>()
        try {
            if(getUser()!=null){
                map["idUser"] = getUser()?.id.toString()
                map["fullNameUser"] = getUser()?.fullName!!
                map["username"] = getUser()?.userName!!
            }else{
                map["idUser"] = ""
                map["fullNameUser"] = ""
                map["username"] = ""
            }
        }catch (e: Exception){
            log(e, logger)
        }
        return map
    }
    
    
}