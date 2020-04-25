package org.lintaspena.elearning.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@Controller
class AcmError : ErrorController {

    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest): String {
        val status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        if (status != null) {
            val statusCode = Integer.valueOf(status.toString())
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "public/common/pagenotfound"
            }
        }

        return "public/common/pagenotfound"
    }

    override fun getErrorPath(): String {
        return "/error"
    }

}