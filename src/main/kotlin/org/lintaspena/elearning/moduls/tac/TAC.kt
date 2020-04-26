package org.lintaspena.elearning.moduls.tac

import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_tac")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["judul_tac"])])
class TAC: BaseModel() {

    @Column(unique = true, name = "judul_tac", length = 50)
    var judulTAC: String? = ""

    @Column(name = "deskripsi_tac")
    var deskripsiTAC: String? = ""

}