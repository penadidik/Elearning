package org.lintaspena.elearning.service

import org.lintaspena.elearning.component.Utils
import org.lintaspena.elearning.base.BaseService
import org.lintaspena.elearning.component.Authenticate
import org.lintaspena.elearning.model.Role
import org.lintaspena.elearning.model.User
import org.lintaspena.elearning.model.UserRole
import org.lintaspena.elearning.repo.UserRoleRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Transactional
@Service
open class UserRoleServiceImpl : BaseService<UserRole>(), UserRoleService {

    override val repo: JpaRepository<UserRole, Long>
        get() = userRoleRepo

    @PersistenceContext
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var auth: Authenticate

    @Autowired
    private lateinit var userRoleRepo: UserRoleRepo

    override fun findByUserId(user: User): List<UserRole> {
        return userRoleRepo.findByUserId(user)
    }

    override fun findByUserIdAndRoleId(user: User, role: Role): List<UserRole> {
        return userRoleRepo.findByUserIdAndRoleId(user, role)
    }

    override fun findAllUserRole(): List<UserRole> {
        return userRoleRepo.findAll().asSequence().toList()
    }

    override fun saveUserRole(userRole: UserRole): UserRole {
        return saveDb(userRole)
    }

    override fun deleteUserRoleById(userRoleId: Long) {
        return userRoleRepo.deleteById(userRoleId)
    }

    override fun findUserRole(): List<Map<String, Any>>? {
        val queryStr = " select coalesce(b.id, 0) id, a.id userid, coalesce(c.id, 0) roleid, a.fullname, a.username, " +
                " coalesce(c.rolename, '') rolename, coalesce(b.is_active, false) isactive " +
                " from tb_m_user a " +
                " left join tb_m_user_role b on b.user_id = a.id " +
                " left join tb_m_roles c on c.id = b.role_id "
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id", "idUser", "idRole", "fullName", "userName", "roleName", "active"))
    }

}