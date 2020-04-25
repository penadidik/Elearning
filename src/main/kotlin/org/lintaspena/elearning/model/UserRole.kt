package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.*

@Entity(name = "tb_m_user_role")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "role_id"])])
class UserRole : BaseModel() {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var userId: User? = null

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    var roleId: Role? = null
}