package org.lintaspena.elearning.moduls.userrole.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@Service
open class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userRoleService: UserRoleService

    override fun loadUserByUsername(userName: String?): UserDetails? {
        val user = userService.findByUserName(userName!!)
        return if (user != null) {
            if (!user.active) return null

            val listRole = userRoleService.findByUserId(user)

            val grantList = ArrayList<GrantedAuthority>()
            if (listRole.isNotEmpty()) {
                for (role in listRole) {
                    val authority = SimpleGrantedAuthority(role.roleId?.roleName)
                    grantList.add(authority)
                }
            }
            val userDetails = User(user.userName, user.password, grantList) as UserDetails
            userDetails
        } else null
    }

}