package org.lintaspena.elearning.utils.base

import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseModel : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "created_by", nullable = true)
    var createdBy: Long? = null

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    var createdDate: Date? = null

    @Column(name = "updated_by", nullable = true)
    var updatedBy: Long? = null

    @Column(name = "updated_date", nullable = true)
    var updatedDate: Date? = null

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    var active: Boolean = true

    @Transient
    var text: String? = ""

}
