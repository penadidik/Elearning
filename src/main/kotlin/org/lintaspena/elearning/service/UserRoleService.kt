package org.lintaspena.elearning.service

import org.lintaspena.elearning.model.Role
import org.lintaspena.elearning.model.User
import org.lintaspena.elearning.model.UserRole

interface UserRoleService {

    fun findUserRole(): List<Map<String, Any>>?

    fun findAllUserRole(): List<UserRole>

    fun findByUserId(user: User): List<UserRole>

    fun findByUserIdAndRoleId(user: User, role: Role): List<UserRole>

    fun saveUserRole(userRole: UserRole): UserRole

    fun deleteUserRoleById(userRoleId: Long)
}