package org.lintaspena.elearning.moduls.metodepembayaran

import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_metode_pembayaran")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_metode"])])
class MetodePembayaran: BaseModel() {

    @Column(unique = true, name = "nama_metode", length = 50)
    var namaMetode: String? = ""

    @Column(name = "deskripsi_metode")
    var deskripsiMetode: String? = ""

    @Column(name = "logo_metode")
    var logoMetode: String? = ""

}