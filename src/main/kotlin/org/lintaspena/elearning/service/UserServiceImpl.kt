package org.lintaspena.elearning.service

import org.lintaspena.elearning.component.Utils
import org.lintaspena.elearning.base.BaseService
import org.lintaspena.elearning.component.Authenticate
import org.lintaspena.elearning.model.User
import org.lintaspena.elearning.repo.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Transactional
@Service
open class UserServiceImpl : BaseService<User>(), UserService {

    override val repo: JpaRepository<User, Long>
        get() = userRepo

    @PersistenceContext
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var userRepo: UserRepo

    @Autowired
    private lateinit var auth: Authenticate

    override fun getAll(): List<User> {
        return userRepo.findAll()
    }

    override fun saveUser(user: User, isChangePwd: Boolean): User {
        val pwd = Utils().encrytePassword(user.password)
        if (user.id == 0L) {
            user.password = pwd
        } else {
            val userDB = userRepo.findByIdOrNull(user.id)!!
            user.userName = userDB.userName
            if (isChangePwd && userDB.password != pwd) {
                user.password = Utils().encrytePassword(user.password)
            } else {
                user.password = userDB.password
            }
        }

        return saveDb(user)
    }

    override fun findByUserName(userName: String): User {
        return userRepo.findByUserName(userName)
    }

    override fun findByFullName(fullName: String): List<User> {
        return userRepo.findByFullName(fullName)
    }

    override fun deleteUserById(userId: Long) {
        return userRepo.deleteById(userId)
    }

    override fun findAllUser(): List<Map<String, Any>>? {
        val queryStr = " select id, fullname, username, is_active from tb_m_user"
        val listData = em.createNativeQuery(queryStr).resultList.toList()
        return Utils().convertToListOfMap(listData, listOf("id", "fullName", "userName", "active"))
    }
}