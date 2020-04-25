package org.lintaspena.elearning.service

import org.lintaspena.elearning.model.User

interface UserService {

    fun getAll(): List<User>

    fun saveUser(user: User, isChangePwd: Boolean): User

    fun findByUserName(userName: String): User

    fun findByFullName(fullName: String): List<User>

    fun deleteUserById(userId: Long)

    fun findAllUser(): List<Map<String, Any>>?
}