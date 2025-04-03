package org.lintaspena.elearning.moduls.userrole.service

import org.lintaspena.elearning.moduls.userrole.model.Role
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.moduls.userrole.model.UserRole

interface UserRoleService {

    fun findUserRole(): List<Map<String, Any>>?

    fun findAllUserRole(): List<UserRole>

    fun findByUserId(user: User): List<UserRole>

    fun findByUserIdAndRoleId(user: User, role: Role): UserRole

    fun saveUserRole(userRole: UserRole): UserRole

    fun deleteUserRoleById(userRoleId: Long)
}