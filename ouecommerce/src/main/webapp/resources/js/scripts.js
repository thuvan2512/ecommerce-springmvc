/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


window.onscroll = function () {
    scrollFunction()
};
function scrollFunction() {
    if (document.body.scrollTop > 120 || document.documentElement.scrollTop > 120) {
        document.querySelector(".button-go-to-top").style.display = "block";
        document.getElementById("navbar").classList.add("fixed-top");
        document.getElementById("search").style.display = "block";
    } else {
        document.querySelector(".button-go-to-top").style.display = "none";
        document.getElementById("navbar").classList.remove("fixed-top");
        document.getElementById("search").style.display = "none";
    }
}
function topFunction() {
    document.documentElement.scrollTop = 0;
    document.body.scrollTop = 0; //safary
}
function clickPage(id) {
//    event.preventDefault();
    var pages = document.getElementsByClassName('page-button');
    for (var i = 0; i < pages.length; i++) {
        pages[i].classList.remove("active");
    }
    var pageActive = document.getElementById(id).classList.add("active");
}

function addComment() {
//    event.preventDefault();
    var content_comment = document.getElementById('content-of-comment').value;
    var patient_comment = document.getElementById('name-of-patient-comment').value;
    var star_comment = document.querySelector('input[name="rating"]:checked');
    if (star_comment != null && patient_comment != "" && content_comment != "") {
        console.log(patient_comment + " - " + content_comment + " - " + star_comment.value);
        alert("Send feedback successfully !!!");
        document.getElementById('content-of-comment').value = "";
        document.getElementById('name-of-patient-comment').value = "";
    } else {
        alert("Please enter all required information");
    }

}
function quickView(endpoint) {
    document.getElementById("spinner-loadquickview").style.display = "block";
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        document.getElementById("spinner-loadquickview").style.display = "none";
        console.log(data[0])
        let inner = "";
        let d = document.getElementById("modal-quickview")
        let fprice = (data[0].finalPrice).toLocaleString('en-US', {
                                    style: 'currency',
                                    currency: 'VND',
                                  });
        inner += `
                             <div class="card" style="width:100%">
                             <div style="width:60%;margin-left:20%">
                            <img  style="width:100%"class="card-img-top" src="${data[0].avatar}" alt="Card image">
                             </div>
                            <div class="card-body row container-fluid">
                                <h4 class="text text-center fw-bold text-danger card-title"> ${data[0].title}</h4>
                                <h5 class="fw-bold text-center">Price: ${fprice}</h5>
                                <div class="text text-center">
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
                                </div>
                            </div>
    `
        d.innerHTML = inner;
        
    })
}