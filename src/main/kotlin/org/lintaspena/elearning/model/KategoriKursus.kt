package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_kategori_kursus")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_kategori"])])
class KategoriKursus: BaseModel() {

    @Column(unique = true, name = "nama_kategori", length = 50)
    var namaKategori: String? = ""

    @Column(name = "deskripsi_kategori")
    var deskripsiKategori: String? = ""

    @Column(name = "icon_kategori")
    var iconKategori: String? = ""

}