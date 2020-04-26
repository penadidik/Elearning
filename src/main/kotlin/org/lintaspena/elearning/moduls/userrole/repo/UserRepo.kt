package org.lintaspena.elearning.moduls.userrole.repo

import org.lintaspena.elearning.moduls.userrole.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : JpaRepository<User, Long> {

    fun findByUserName(userName: String): User

    @Query(nativeQuery = true, value = "select * from tb_m_user where is_active is true and lower(fullname) like lower(CONCAT('%',?1,'%')) ")
    fun findByFullName(fullName: String): List<User>
}