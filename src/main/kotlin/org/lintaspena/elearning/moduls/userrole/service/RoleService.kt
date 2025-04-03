package org.lintaspena.elearning.moduls.userrole.service

import org.lintaspena.elearning.moduls.userrole.model.Role

interface RoleService {

    fun findAllRole(): List<Role>

    fun saveRole(role: Role): Role

    fun deleteRoleById(roleId: Long)

    fun findByRoleName(roleName: String): Role

    fun findById(roleId: Long): Role

}