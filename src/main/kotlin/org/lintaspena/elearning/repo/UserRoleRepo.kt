package org.lintaspena.elearning.repo

import org.lintaspena.elearning.model.Role
import org.lintaspena.elearning.model.User
import org.lintaspena.elearning.model.UserRole
import org.springframework.data.jpa.repository.JpaRepository

interface UserRoleRepo : JpaRepository<UserRole, Long> {

    fun findByUserId(user: User): List<UserRole>

    fun findByUserIdAndRoleId(user: User, role: Role): List<UserRole>

}