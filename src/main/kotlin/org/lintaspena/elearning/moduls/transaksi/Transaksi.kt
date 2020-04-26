package org.lintaspena.elearning.moduls.transaksi

import org.lintaspena.elearning.moduls.kelas.Kelas
import org.lintaspena.elearning.moduls.metodepembayaran.MetodePembayaran
import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tb_m_transaksi")
class Transaksi: BaseModel() {

    @Column(name = "validasi_learning")
    var validasiLearning: Int? = 0

    @Column(name = "nilai_akhir")
    var nilaiAkhir: Int? = 0

    @Column(name = "keterangan")
    var keterangan: String? = ""

    @Column(name = "sertifikat")
    var sertifikat: String? = ""

    @Column(name = "validasi_pembayaran")
    var validasiPembayaran: String? = ""

    @Column(name = "upload_pembayaran")
    var uploadPembayaran: String? = ""

    @ManyToOne
    @JoinColumn(name = "id_peserta", nullable = false)
    var peserta: User? = null

    @ManyToOne
    @JoinColumn(name = "id_kelas", nullable = false)
    var kelas: Kelas? = null

    @ManyToOne
    @JoinColumn(name = "id_metode", nullable = false)
    var metodePembayaran: MetodePembayaran? = null

}