var pageTitle = "Akun";

function loadKelasTerbaru(){
     $.ajax({
         url: apiurl("kelas/allNewKelas/1"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';

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
         url: apiurl("kelas/allKelasBestSeller/1"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';

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
         url: apiurl("kelas/all/1"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i] == null){
                 kelas += '<div class="list-inline-item box-product"><div class="col-lg-12 col-md-12"><div class="row"><div class="col-lg-4 col-md-3"><img src="'+gambar[0]+'" class="img-product img-responsive"></div><div class="col-lg-8 col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>Manajemen</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri 1</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div>';

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

function loadMenu(){
    $.ajax({
        url: apiurl("menu/all"),
        dataType: 'json',
        type: "GET",
        success: function (res) {
            var response = JSON.parse(JSON.stringify(res));
            var i = 0;
            var menu = '<div class="col-md-4 col-lg-3"></div>';
            if(response[i] == null){
                while(i < menu_member.length){
                    menu += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="'+link_member[i]+'" class="d-block p-lg-4 p-3"><img src="'+gambar[i]+'" alt="" class="img-fluid"><h3 class="my-3">'+menu_member[i]+'</h3></a></div></div>';
                    i++;
                }
            }else{
                while(i < response.length){
                    menu += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="'+link_member[i]+'" class="d-block p-lg-4 p-3"><img src="'+gambar[i]+'" alt="" class="img-fluid"><h3 class="my-3">'+menu_member[i]+'</h3></a></div></div>';
                    i++;
                }
            }
            $('#menu').html(menu);
        },
        error: function (res) {
            var menu = '<div class="col-md-4 col-lg-3"></div>';
            var i = 0;
            while(i < menu_member.length){
                menu += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="'+link_member[i]+'" class="d-block p-lg-4 p-3"><img src="'+gambar[i]+'" alt="" class="img-fluid"><h3 class="my-3">'+menu_member[i]+'</h3></a></div></div>';
                i++;
            }
            $('#menu').html(menu);
        }
    });
}