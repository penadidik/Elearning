package org.lintaspena.elearning.moduls.userrole.model

import org.lintaspena.elearning.utils.base.BaseModel
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

    @Column(name = "pwd", length = 17, nullable = false)
    var password: String? = ""

    @Column(name = "pwd_confirmation", length = 17, nullable = false)
    var passwordConfirmation: String? = ""

    @Column(name = "telp", length = 15, nullable = false)
    var telp: String? = ""

    @Column(name = "alamat")
    var alamat: String? = ""

    @Column(name = "no_ktp", length = 16, nullable = false)
    var noKtp: Int? = 0

    @Column(name = "photo")
    var photo: String? = ""

}