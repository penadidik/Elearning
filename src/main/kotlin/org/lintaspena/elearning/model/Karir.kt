package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_karir")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["judul_karir"])])
class Karir: BaseModel() {

    @Column(unique = true, name = "judul_karir", length = 50)
    var judulKarir: String? = ""

    @Column(name = "deskripsi_karir")
    var deskripsiKarir: String? = ""

    @Column(name = "salary")
    var salary: Int? = 0

}