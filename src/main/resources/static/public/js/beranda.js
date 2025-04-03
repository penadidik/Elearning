var pageTitle = "Beranda";

function loadSlide(){
    $.ajax({
        url: apiurl("slide/all"),
        dataType: 'json',
        type: "GET",
        success: function (res) {
            var response = JSON.parse(JSON.stringify(res));
            var i = 0;
            if(response[i] == null){
                var slide = '<div class="w3l-index-block1"><div class="content py-5"><div class="container"><div class="row align-items-center py-md-5 py-3"><div class="col-md-2"></div><div class="col-md-3 content-photo mt-md-0 mt-5"><img src="public/images/main.png" class="img-banner" alt="main image"></div><div class="col-md-5 content-left pt-md-0 pt-5"><h1 style="color:#498DB7;">Wujudkan Impianmu Bersama Kami</h1><p class="mt-3 mb-md-5 mb-4">Jadilah tuan rumah di negeri sendiri dengan belajar langsung dari para inovator dan developer expert.</p><a href="/login" class="btn btn-primary btn-theme">Get Started</a></div><div class="col-md-2"></div></div><div class="clear"></div></div></div></div>';
            }else{
                var slide = '<div class="w3l-index-block1"><div class="content py-5"><div class="container"><div class="row align-items-center py-md-5 py-3"><div class="col-md-2"></div><div class="col-md-3 content-photo mt-md-0 mt-5"><img src="'+response[i].gambarSlide+'" class="img-banner" alt="main image"></div><div class="col-md-5 content-left pt-md-0 pt-5"><h1 style="color:#498DB7;">'+response[i].judulSlide+'</h1><p class="mt-3 mb-md-5 mb-4">'+response[i].deskripsiSlide+'</p><a href="/login" class="btn btn-primary btn-theme">Get Started</a></div><div class="col-md-2"></div></div><div class="clear"></div></div></div></div>';
            }
            $('#slide').html(slide);
        },
        error: function (res) {
            console.log("Error Code: "+res);
        }
    });
}

function loadKategoriKursus(){
    $.ajax({
        url: apiurl("kategorikursus/all"),
        dataType: 'json',
        type: "GET",
        success: function (res) {
            var response = JSON.parse(JSON.stringify(res));
            var i = 0;
            var slide = '';
            while(i < 6){
                if(response[i] == null){
                    slide += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="/kursus" class="d-block p-lg-4 p-3"><img src="'+gambar[i]+'" alt="" class="img-fluid" /><h3 class="my-3">'+judul[i]+'</h3><p class="row">Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></a></div></div>';
                }else{
                    slide += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="/kursus" class="d-block p-lg-4 p-3"><img src="'+response[i].iconKategori+'" alt="" class="img-fluid" /><h3 class="my-3">'+response[i].namaKategori+'</h3><p class="">'+response[i].deskripsiKategori+'</p></a></div></div>';
                }
                i++;
            }
            $('#kategori').html(slide);
        },
        error: function (res) {
            console.log("Error Code: "+res);
        }
    });
}

function loadPartner(){
     $.ajax({
         url: apiurl("partner/all"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var partner = '';
             while(i < 6){
                if(response[i] == null){
                    partner += '<div class="parts-w3ls col-sm-2 col-6 mt-5"><img src="'+gambar[i]+'" class="img-partner" title="'+judul[i]+'"></div>';
                }else{
                    partner += '<div class="parts-w3ls col-sm-2 col-6 mt-5"><img src="'+response[i].logoPartner+'" class="img-partner" title="'+response[i].namaPartner+'"></div>';
                }
                i++;
             }
             $('#partner').html(partner);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}

function loadTestimoni(){
     $.ajax({
         url: apiurl("testimoni/all"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var testimoni = '';

            if(response[i] == null){
                testimoni += '<div class="item"><div class="row slider-info mt-lg-4 mt-3"><div class="col-md-1"></div><div class="col-md-2"><img src="'+gambar[0]+'" class="img-fluid rounded" alt="client image"></div><div class="col-md-8 text-left"><div class="row"><div class="col-md-2 col-lg-3">Nama Lengkap</div><div class="col-md-1">:</div><div class="col-md-3">Member A</div></div><div class="row"><div class="col-md-2 col-lg-3">Kelas Diikuti</div><div class="col-md-1">:</div><div class="col-md-3">Manajemen</div></div><div class="row"><div class="col-md-12">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea sit id accusantium officia quod quasi necessitatibus perspiciatis Harum error provident quibusdam tenetur.</div> </div></div><div class="col-md-1"></div></div></div>';
            }else{
                while(i < response.length){
                    testimoni += '<div class="item"><div class="row slider-info mt-lg-4 mt-3"><div class="col-md-1"></div><div class="col-md-2"><img src="'+response[i].photoPeserta+'" class="img-fluid rounded" alt="client image"></div><div class="col-md-8 text-left"><div class="row"><div class="col-md-2 col-lg-3">Nama Lengkap</div><div class="col-md-1">:</div><div class="col-md-3">'+response[i].fullnamePeserta+'</div></div><div class="row"><div class="col-md-2 col-lg-3">Kelas Diikuti</div><div class="col-md-1">:</div><div class="col-md-3">'+response[i].namaKelas+'</div></div><div class="row"><div class="col-md-12">'+response[i].isiTestimoni+'</div> </div></div><div class="col-md-1"></div></div></div>';
                    i++;
                }
            }

             $('#testimoni').html(testimoni);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}

function loadKelasTerbaru(){
     $.ajax({
         url: apiurl("kelas/allNewKelas/3"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[1]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Teknologi Informasi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 2</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[2]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Akuntansi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 3</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
             }else{
                while(i < response.length){
                    kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+response[i].photoKelas+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>'+response[i].namaKelas+'</h4><p>'+response[i].deskripsiKelas+'</p></div></div><div class="col-md-12"><i>Pemateri:  <b>'+response[i].pemateri+'</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">'+formatRupiah(response[i].hargaKelas,"Rp. ")+'</div></div></div></div>';
                    i++;
                }
             }
             $('#kelasterbaru').html(kelas);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}

function loadKelasBestSeller(){
     $.ajax({
         url: apiurl("kelas/allKelasBestSeller/3"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[1]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Teknologi Informasi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 2</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[2]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Akuntansi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 3</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
              }else{
                 while(i < response.length){
                     kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+response[i].photoKelas+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>'+response[i].namaKelas+'</h4><p>'+response[i].deskripsiKelas+'</p></div></div><div class="col-md-12"><i>Pemateri:  <b>'+response[i].pemateri+'</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">'+formatRupiah(response[i].hargaKelas,"Rp. ")+'</div></div></div></div>';
                     i++;
                 }
              }
             $('#kelasbestseller').html(kelas);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}

function loadSemuaKelas(){
     $.ajax({
         url: apiurl("kelas/all/3"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[1]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Teknologi Informasi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 2</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[2]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Akuntansi</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 3</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';
              }else{
                 while(i < response.length){
                     kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+response[i].photoKelas+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>'+response[i].namaKelas+'</h4><p>'+response[i].deskripsiKelas+'</p></div></div><div class="col-md-12"><i>Pemateri:  <b>'+response[i].pemateri+'</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">'+formatRupiah(response[i].hargaKelas,"Rp. ")+'</div></div></div></div>';
                     i++;
                 }
              }
             $('#semuakelas').html(kelas);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}