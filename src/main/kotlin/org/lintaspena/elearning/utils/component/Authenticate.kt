package org.lintaspena.elearning.utils.component

import org.lintaspena.elearning.moduls.userrole.model.Role
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.moduls.userrole.service.RoleService
import org.lintaspena.elearning.moduls.userrole.service.UserRoleService
import org.lintaspena.elearning.moduls.userrole.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class Authenticate {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userRoleService: UserRoleService

    @Autowired
    private lateinit var roleService: RoleService

    fun Auth(): User? {
        val auth = SecurityContextHolder.getContext().authentication
        if (auth !is AnonymousAuthenticationToken) {
            val userDetails = auth.principal as UserDetails
            val userName = userDetails.username
            return userService.findByUserName(userName!!)
        }
        return null
    }

    fun getUser(): User? = Auth()

    fun getUserId(): Long? = Auth()?.id

    fun getRole(): List<Role> {
        val user = User()
        user.id = getUserId()
        val listUserRole = userRoleService.findByUserId(user)
        val listRole = ArrayList<Role>()
        listUserRole.forEach {
            val role = roleService.findById(it.roleId?.id!!)
            listRole.add(role)
        }
        return listRole
    }
}