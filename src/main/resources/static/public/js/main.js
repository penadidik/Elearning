var baseApp = "E-Learning";
var metaA = document.createElement('meta');
var metaB = document.createElement('meta');
var metaC = document.createElement('meta');
var link = document.createElement('link');

$(document).ready(function () {
    loadGeneral();
    loadSlide();
    loadKategoriKursus();
    loadPartner()
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
            }else{
                $("#logo").html(response[0].namaApp);
            }

            if(response[0] == null){
                $("#nama_app").html(baseApp);
            }else{
                $("#nama_app").html(response[0].namaApp);
            }

            if(response[0] == null){
                $("#company").html(baseApp);
            }else{
                $("#company").html(response[0].namaCompany);
            }

            if(response[0] == null){
                $("#address_company").html("");
            }else{
                $("#address_company").html(response[0].addressCompany);
            }

            if(response[0] == null){
                $("#phone_company").html("");
            }else{
                $("#phone_company").html(response[0].telpCompany);
            }

            if(response[0] == null){
                $("#email_company").html("");
            }else{
                $("#email_company").html(response[0].emailCompany);
            }
        },
        error: function (res) {
            console.log("Error Code: "+res);
        }
    });
}

function apiurl(path) {
    return "/api/public/" + path;
}