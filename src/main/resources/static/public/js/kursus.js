var pageTitle = "Kursus";

function loadSemuaKelas(){
     $.ajax({
         url: apiurl("kelas/all/0"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var kelas = '';
             if(response[i]==null){
                while(i < 6){
                    kelas += '<div class="col-md-4 features15-col-text"><div class="d-flex flex-wrap feature-unit align-items-center"><div class="list-inline-item"><div class="col-md-12"><div class="row"><div class="col-md-3"><img src="'+gambar[i]+'" class="img-product"></div><div class="col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>'+judul[i]+'</h4><p>Our goal is to help our companies maintain or achieve best in class positions. Build an online presence with this professional bootstrap 4 template.</p></div></div><div class="col-md-12"><i>Pemateri:  <b>Pemateri '+(i+1)+'</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">Rp. 50.000</div></div></div></div></div></div>';
                    i++;
                 }
             }else{
                while(i < response.length){
                    kelas += '<div class="col-md-4 features15-col-text"><div class="d-flex flex-wrap feature-unit align-items-center"><div class="list-inline-item"><div class="col-md-12"><div class="row"><div class="col-md-3"><img src="'+response[i].photoKelas+'" class="img-product"></div><div class="col-md-9"><div class="row"><div class="col-md-12"><div class="features15-para"><h4>'+response[i].namaKelas+'</h4><p>'+response[i].deskripsiKelas+'</p></div></div><div class="col-md-12"><i>Pemateri:  <b>'+response[i].pemateri+'</b></i></div></div></div></div><div class="row"><div class="col-md-12">&nbsp;</div></div><div class="row"><div class="btn btn-primary col-md-6">BELI KELAS ONLINE</div><div class="col-md-2"></div><div class="col-md-4 btn btn-light disabled">'+formatRupiah(response[i].hargaKelas,"Rp. ")+'</div></div></div></div></div></div>';
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

function loadKategoriDropdown(){
     $.ajax({
         url: apiurl("kategorikursus/all"),
         dataType: 'json',
         type: "GET",
         success: function (res) {
             var response = JSON.parse(JSON.stringify(res));
             var i = 0;
             var no=0;
             var kategori = '<option disabled selected>Pilih Kategori</option>';

            if(response[i]==null){
                while(i < 6){
                    no=i+1;
                    kategori += '<option value="'+no+'">'+judul[i]+'</option>';
                    i++;
                }
            }else{
                while(i < response.length){
                    kategori += '<option value="'+response[i].id+'">'+response[i].namaKategori+'</option>';
                    i++;
                }
            }
             $('#kategori').html(kategori);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}