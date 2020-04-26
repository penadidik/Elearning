package org.lintaspena.elearning.moduls.kelas

import org.lintaspena.elearning.moduls.kategorikursus.KategoriKursus
import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.*

@Entity(name = "tb_m_kelas")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_kelas"])])
class Kelas: BaseModel() {

    @Column(unique = true, name = "nama_kelas", length = 50)
    var namaKelas: String? = ""

    @Column(name = "deskripsi_kelas")
    var deskripsiKelas: String? = ""

    @Column(name = "jumlah_materi")
    var jumlahMater: Int? = 0

    @Column(name = "harga_kelas")
    var hargaKelas: Int? = 0

    @ManyToOne
    @JoinColumn(name = "id_kategori", nullable = false)
    var kategoriKursus: KategoriKursus? = null

}