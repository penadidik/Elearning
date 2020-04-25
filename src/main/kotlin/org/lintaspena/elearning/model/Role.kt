package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_roles")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["rolename"])])
class Role : BaseModel() {

    @Column(unique = true, name = "rolename", length = 50, nullable = false)
    var roleName: String? = null
}