package org.lintaspena.elearning.moduls.general

import org.lintaspena.elearning.utils.base.BaseModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity(name = "tb_m_general")
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["nama_app"])])
class General: BaseModel() {

    @Column(unique = true, name = "nama_app", length = 50)
    var namaApp: String? = ""

    @Column(name = "meta_deskripsi")
    var metaDeskripsi: String? = ""

    @Column(unique = true, name = "nama_company", length = 50)
    var namaCompany: String? = ""

    @Column(name = "deskripsi_company")
    var deskripsiCompany: String? = ""

    @Column(name = "address_company")
    var addressCompany: String? = ""

    @Column(name = "visi_company")
    var visiCompany: String? = ""

    @Column(name = "misi_company")
    var misiCompany: String? = ""

    @Column(name = "logo_company")
    var logoCompany: String? = ""

    @Column(name = "icon_company")
    var iconCompany: String? = ""

    @Column(name = "telp_company", length = 15)
    var telpCompany: String? = ""

    @Column(name = "email_company")
    var emailCompany: String? = ""

    @Column(name = "link_fb")
    var linkFb: String? = ""

    @Column(name = "link_twitter")
    var linkTwitter: String? = ""

    @Column(name = "link_google")
    var linkGoogle: String? = ""

    @Column(name = "link_instagram")
    var linkInstagram: String? = ""

}