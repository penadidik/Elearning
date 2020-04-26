package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_partner")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_partner"])])
class Partner: BaseModel() {

    @Column(unique = true, name = "nama_partner", length = 50)
    var namaPartner: String? = ""

    @Column(name = "deskripsi_partner")
    var deskripsiPartner: String? = ""

    @Column(name = "logo_partner")
    var logoPartner: String? = ""

}