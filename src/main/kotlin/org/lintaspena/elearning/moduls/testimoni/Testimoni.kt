package org.lintaspena.elearning.moduls.testimoni

import org.lintaspena.elearning.moduls.kelas.Kelas
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tb_m_testimoni")
class Testimoni: BaseModel() {

    @Column(unique = true, name = "judul_testimoni", length = 50)
    var judulTestimoni: String? = ""

    @Column(name = "isi_testimoni")
    var isiTestimoni: String? = ""

    @Column(name = "ratingKelas")
    var ratingKelas: String? = ""

    @ManyToOne
    @JoinColumn(name = "id_peserta", nullable = false)
    var peserta: User? = null

    @ManyToOne
    @JoinColumn(name = "id_kelas", nullable = false)
    var kelas: Kelas? = null

}