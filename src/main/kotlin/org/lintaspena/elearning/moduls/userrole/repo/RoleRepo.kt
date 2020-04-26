package org.lintaspena.elearning.moduls.userrole.repo

import org.lintaspena.elearning.moduls.userrole.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RoleRepo : JpaRepository<Role, Long> {

    fun deleteRoleById(id: Long)

    @Query(nativeQuery = true, value = "select * from tb_m_roles where is_active is true and lower(rolename) like CONCAT('%',?1,'%') ")
    fun findByRoleName(roleName: String): List<Role>
}