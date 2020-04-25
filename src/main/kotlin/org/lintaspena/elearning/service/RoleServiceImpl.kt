package org.lintaspena.elearning.service

import org.lintaspena.elearning.base.BaseService
import org.lintaspena.elearning.component.Authenticate
import org.lintaspena.elearning.model.Role
import org.lintaspena.elearning.repo.RoleRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class RoleServiceImpl : BaseService<Role>(), RoleService {

    override val repo: JpaRepository<Role, Long>
        get() = roleRepo

    @Autowired
    private lateinit var roleRepo: RoleRepo

    @Autowired
    private lateinit var auth: Authenticate

    override fun findById(roleId: Long): Role {
        return roleRepo.findByIdOrNull(roleId)!!
    }

    override fun findAllRole(): List<Role> {
        return roleRepo.findAll().asSequence().toList()
    }

    override fun saveRole(role: Role): Role {
        return saveDb(role)
    }

    override fun deleteRoleById(roleId: Long) {
        return roleRepo.deleteRoleById(roleId)
    }

    override fun findByRoleName(roleName: String): List<Role> {
        return roleRepo.findByRoleName(roleName)
    }
}