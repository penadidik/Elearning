package org.lintaspena.elearning.model

import org.lintaspena.elearning.base.BaseModel
import javax.persistence.*

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