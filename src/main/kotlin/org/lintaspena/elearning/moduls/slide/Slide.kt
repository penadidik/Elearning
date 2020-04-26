package org.lintaspena.elearning.moduls.slide

import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_slide")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["judul_slide"])])
class Slide: BaseModel() {

    @Column(unique = true, name = "judul_slide", length = 50)
    var judulSlide: String? = ""

    @Column(name = "deskripsi_slide")
    var deskripsiSlide: String? = ""

    @Column(name = "gambar_slide")
    var gambarSlide: String? = ""

}