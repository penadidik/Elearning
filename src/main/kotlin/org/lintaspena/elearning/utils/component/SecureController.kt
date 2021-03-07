package org.lintaspena.elearning.utils.component

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.lintaspena.elearning.utils.base.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
abstract class SecureController: BaseController() {

    @Autowired
    private lateinit var auth: Authenticate

    private var gson = Gson()

    init {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.disableHtmlEscaping()
        gson = gsonBuilder.create()
    }

    abstract fun controllClass(): String

    fun hasAccessApiEx(): Boolean {
        val roleArr = getRole()
        val roleApiEx = roleArr.filter {
            it.roleName == Constant.Default.role_api_ex
                    || isSuperAdmin()
        }.size

        return roleApiEx > 0
    }

    private val mapper = ObjectMapper()

    fun getUser() = auth.getUser()

    fun getUserId() = auth.getUserId()

    fun getRole() = auth.getRole()

    fun isSuperAdmin(): Boolean {
        val roleApiEx = getRole().filter {
            it.roleName == Constant.Default.role_api_ex
                    || it.roleName == Constant.Default.role_super
        }.size

        return roleApiEx > 0
    }

}