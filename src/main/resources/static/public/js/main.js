var baseApp = "E-Learning";
var metaA = document.createElement('meta');
var metaB = document.createElement('meta');
var metaC = document.createElement('meta');
var link = document.createElement('link');
var judul = ['Teknologi','Software','Bisnis','Pemasaran','Perkantoran','Partnership'];
var menu_member = ['Profile','Pembelian','Kelas Saya'];
var link_member = ['/profile','/pembelian','/kelassaya'];
var gambar = ['public/images/s1.png','public/images/s2.png','public/images/s3.png','public/images/s2.png','public/images/s3.png','public/images/s1.png'];

$(document).ready(function () {
openDataUser();
loadGeneral();
loadKelasFooter();
    if(pageTitle=='Beranda'){
        loadSlide();
        loadKategoriKursus();
        loadKelasTerbaru();
        loadKelasBestSeller();
        loadSemuaKelas();
        loadTestimoni();
        loadPartner();
        loadTestimoni();
        loadPartner();
    }else if(pageTitle=='Kursus'){
        loadKategoriDropdown();
        loadSemuaKelas();
    }else if(pageTitle=="Tentang"){
        loadPartner();
    }else if(pageTitle=="Akun"){
        loadMenu();
        loadKelasTerbaru();
        loadKelasBestSeller();
        loadSemuaKelas();
    }else if(pageTitle=="Profile"){
         loadKelasTerbaru();
         loadKelasBestSeller();
         loadSemuaKelas();
    }else if(pageTitle=="Pembelian"){
         loadKelasTerbaru();
         loadKelasBestSeller();
         loadSemuaKelas();
    }else if(pageTitle=="Kelas Saya"){
         loadKelasTerbaru();
         loadKelasBestSeller();
         loadSemuaKelas();
    }
});

function loadGeneral(){
    $.ajax({
        url: apiurl("general/all"),
        dataType: 'json',
        type: "GET",
        success: function (res) {
            var response = JSON.parse(JSON.stringify(res));

            if(response[0] == null){
                document.title = baseApp+" - "+pageTitle;
            }else{
                document.title = response[0].namaApp+" - "+pageTitle;
            }

            metaA.name = "description";
            if(response[0] == null){
                metaA.content = baseApp;
            }else{
                metaA.content = response[0].metaDeskripsi;
            }
            var metaReadyA = document.head;
            metaReadyA.append(metaA);

            metaB.name = "keywords";
            if(response[0] == null){
                metaB.content = baseApp;
            }else{
                metaB.content = response[0].metaKeyword;
            }
            var metaReadyB = document.head;
            metaReadyB.append(metaB);

            metaC.name = "author";
            metaC.content = "Didik Maryono";
            var metaReadyC = document.head;
            metaReadyC.append(metaC);

            link.rel = "icon";
            if(response[0] == null){
                link.href = "public/images/app.png";
            }else{
                link.href = response[0].iconApp;
            }
            link.type = "image/png"
            var linkReady = document.head;
            linkReady.append(link);

            if(response[0] == null){
                $("#logo").html(baseApp);
                $("#nama_app").html(baseApp);
                $("#company").html("LintasPena.org");
                $("#address_company_footer").html("Pare, Selogiri, Wonogiri 57652");
                $("#phone_company_footer").html("087812538105");
                $("#email_company_footer").html("admin@lintaspena.org");
            }else{
                $("#logo").html(response[0].namaApp);
                $("#nama_app").html(response[0].namaApp);
                $("#company").html(response[0].namaCompany);
                $("#address_company_footer").html(response[0].addressCompany);
                $("#phone_company_footer").html(response[0].telpCompany);
                $("#email_company_footer").html(response[0].emailCompany);
            }

            if(pageTitle=="Kontak"){
                if(response[0] == null){
                    $("#address_company").html("Pare, Selogiri, Wonogiri 57652");
                    $("#phone_company").html("087812538105");
                    $("#email_company").html("admin@lintaspena.org");
                    document.getElementById("maps").src = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d998.0190851639685!2d110.89601488506052!3d-7.815230939372886!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xa391b688a2c63a55!2sUJ%20LintasPena.Com!5e1!3m2!1sen!2sid!4v1588004852519!5m2!1sen!2sid";
                }else{
                    $("#address_company").html(response[0].addressCompany);
                    $("#phone_company").html(response[0].telpCompany);
                    $("#email_company").html(response[0].emailCompany);
                    if(response[0].googleMap!=null){
                        document.getElementById("maps").src = response[0].googleMap;
                    }else{
                        document.getElementById("maps").src = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d998.0190851639685!2d110.89601488506052!3d-7.815230939372886!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xa391b688a2c63a55!2sUJ%20LintasPena.Com!5e1!3m2!1sen!2sid!4v1588004852519!5m2!1sen!2sid";
                    }
                }
            }

            if(pageTitle=="Tentang"){
                if(response[0] == null ){
                    $("#tentangCompany").html("Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea sit id accusantium officia quod quasi necessitatibus perspiciatis Harum error provident quibusdam teneturLorem ipsum dolor sit amet consectetur adipisicing elit. Ea sit id accusantium officia quod quasi necessitatibus perspiciatis Harum error provident quibusdam teneturLorem ipsum dolor sit amet consectetur adipisicing elit. Ea sit id accusantium officia quod quasi necessitatibus perspiciatis Harum error provident quibusdam teneturLorem ipsum dolor sit amet consectetur adipisicing elit. Ea sit id accusantium officia quod quasi necessitatibus perspiciatis Harum error provident quibusdam tenetur");
                    $("#visiCompany").html("Lorem ipsum dolor sit amet consectetur adipisicing elit.");
                    $("#misiCompany").html("Lorem ipsum dolor sit amet consectetur adipisicing elit.");
                    document.getElementById("logoCompany").src = "public/images/s2.png";
                }else{
                    $("#tentangCompany").html(response[0].deskripsiCompany);
                    $("#visiCompany").html(response[0].visiCompany);
                    $("#misiCompany").html(response[0].misiCompany);
                    document.getElementById("logoCompany").src = response[0].logoCompany;
                }
            }
        },
        error: function (res) {
            console.log("Error Code: "+res);
        }
    });
}

function loadKelasFooter(){
     $.ajax({
         url: apiurl("kelas/allNewKelas/3"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i]==null){
                while(i < 3){
                    kelas += '<li><a href="/kursus">'+judul[i]+'</a></li>';
                    i++;
                 }
             }else{
                while(i < response.length){
                    kelas += '<li><a href="/kursus">'+response[i].namaKelas+'</a></li>';
                    i++;
                 }
             }
             $('#kelasFooter').html(kelas);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}

function apiurl(path) {
    return "/api/public/" + path;
}

function formatRupiah(angka, prefix){
	var number_string = angka.toString().replace(/[^,\d]/g, ''),
	split   		= number_string.split(','),
	sisa     		= split[0].length % 3,
	rupiah     		= split[0].substr(0, sisa),
	ribuan     		= split[0].substr(sisa).match(/\d{3}/gi);

	// tambahkan titik jika yang di input sudah menjadi angka ribuan
	if(ribuan){
		separator = sisa ? '.' : '';
		rupiah += separator + ribuan.join('.');
	}

	rupiah = split[1] != undefined ? rupiah + ',' + split[1] : rupiah;
	return prefix == undefined ? rupiah : (rupiah ? 'Rp. ' + rupiah : '');
}

function openDataUser() {
    var akun='';
    $.ajax({
        url: "/api/private/session",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var response = JSON.parse(JSON.stringify(data));
            if(response.idUser==""){
                akun +='<a href="/login" class="btn btn-primary btn-theme">Masuk/Daftar</a>';
            }else{
                akun +='<a href="/profile" class="login mr-4">Welcome, '+response.fullNameUser+'</a><a href="/logout" class="btn btn-danger">Logout</a>';
            }
            $('#akun').html(akun);
        },
        error: function (res) {
            akun +='<a href="/login" class="btn btn-primary btn-theme">Masuk/Daftar</a>';
            $('#akun').html(akun);
            console.log(res);
        }
    });
}