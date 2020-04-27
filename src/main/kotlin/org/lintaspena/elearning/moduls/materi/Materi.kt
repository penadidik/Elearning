package org.lintaspena.elearning.moduls.materi

import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.*

@Entity(name = "tb_m_materi")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_materi"])])
class Materi: BaseModel() {

    @Column(unique = true, name = "nama_materi", length = 50)
    var namaMateri: String? = ""

    @Column(name = "deskripsi_materi")
    var deskripsiMateri: String? = ""

    @Column(name = "isi_materi")
    var isiMateri: String? = ""

    @ManyToOne
    @JoinColumn(name = "id_pemateri", nullable = false)
    var pemateri: User? = null

}