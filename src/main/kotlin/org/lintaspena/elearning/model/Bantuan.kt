package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_bantuan")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["judul_bantuan"])])
class Bantuan: BaseModel() {

    @Column(unique = true, name = "judul_bantuan", length = 50)
    var judulSlide: String? = ""

    @Column(name = "deskripsi_bantuan")
    var deskripsiBantuan: String? = ""

}