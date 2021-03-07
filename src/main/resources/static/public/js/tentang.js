var pageTitle = "Tentang";

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