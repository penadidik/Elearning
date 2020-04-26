package org.lintaspena.elearning.moduls.userrole.repo

import org.lintaspena.elearning.moduls.userrole.model.Role
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.moduls.userrole.model.UserRole
import org.springframework.data.jpa.repository.JpaRepository

interface UserRoleRepo : JpaRepository<UserRole, Long> {

    fun findByUserId(user: User): List<UserRole>

    fun findByUserIdAndRoleId(user: User, role: Role): List<UserRole>

}