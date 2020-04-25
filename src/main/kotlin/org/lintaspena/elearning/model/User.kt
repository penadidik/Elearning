package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_user")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["username"])])
class User : BaseModel() {

    @Column(unique = true, name = "username", length = 50)
    var userName: String? = ""

    @Column(unique = true, name = "fullname", length = 50)
    var fullName: String? = ""

    @Column(name = "pwd", length = 255, nullable = false)
    var password: String? = ""

}