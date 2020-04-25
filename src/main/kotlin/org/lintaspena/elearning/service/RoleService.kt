package org.lintaspena.elearning.service

import org.lintaspena.elearning.model.Role

interface RoleService {

    fun findAllRole(): List<Role>

    fun saveRole(role: Role): Role

    fun deleteRoleById(roleId: Long)

    fun findByRoleName(roleName: String): List<Role>

    fun findById(roleId: Long): Role

}