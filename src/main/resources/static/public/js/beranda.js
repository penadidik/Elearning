var pageTitle = "Beranda";

function loadSlide(){
    $.ajax({
        url: apiurl("slide/all"),
        dataType: 'json',
        type: "GET",
        success: function (res) {
            var response = JSON.parse(JSON.stringify(res));
            var i = 0;
            var slide = '<div class="w3l-index-block1"><div class="content py-5"><div class="container"><div class="row align-items-center py-md-5 py-3"><div class="col-md-2"></div><div class="col-md-3 content-photo mt-md-0 mt-5"><img src="'+response[i].gambarSlide+'" class="img-banner" alt="main image"></div><div class="col-md-5 content-left pt-md-0 pt-5"><h1 style="color:#498DB7;">'+response[i].judulSlide+'</h1><p class="mt-3 mb-md-5 mb-4">'+response[i].deskripsiSlide+'</p><a href="/login" class="btn btn-primary btn-theme">Get Started</a></div><div class="col-md-2"></div></div><div class="clear"></div></div></div></div>';
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
            while(i < response.length){
                slide += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="/kursus" class="d-block p-lg-4 p-3"><img src="'+response[i].iconKategori+'" alt="" class="img-fluid" /><h3 class="my-3">'+response[i].namaKategori+'</h3><p class="">'+response[i].deskripsiKategori+'</p></a></div></div>';
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
             while(i < response.length){
                 partner += '<div class="col-lg-2 col-md-3 mt-5"><div class="s-block"><a href="/kursus" class="d-block p-lg-4 p-3"><img src="'+response[i].iconKategori+'" alt="" class="img-fluid" /><h3 class="my-3">'+response[i].namaKategori+'</h3><p class="">'+response[i].deskripsiKategori+'</p></a></div></div>';
                 i++;
             }
             $('#partner').html(partner);
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
             while(i < response.length){
                 partner += '<div class="parts-w3ls col-sm-2 col-6 mt-5"><img src="'+response[i].logoPartner+'" class="img-partner" title="'+response[i].namaPartner+'"></div>';
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
             while(i < response.length){
                testimoni += '<div class="item"><div class="row slider-info mt-lg-4 mt-3"><div class="col-md-1"></div><div class="col-md-2"><img src="'+response[i].photoPeserta+'" class="img-fluid rounded" alt="client image"></div><div class="col-md-8 text-left"><div class="row"><div class="col-md-2">Nama Lengkap</div><div class="col-md-1">:</div><div class="col-md-3">'+response[i].fullnamePeserta+'</div></div><div class="row"><div class="col-md-2">Kelas Diikuti</div><div class="col-md-1">:</div><div class="col-md-3">'+response[i].namaKelas+'</div></div><div class="row"><div class="col-md-12">'+response[i].isiTestimoni+'</div> </div></div><div class="col-md-1"></div></div></div>';
                i++;
             }
             $('#testimoni').html(testimoni);
         },
         error: function (res) {
             console.log("Error Code: "+res);
         }
     });
}