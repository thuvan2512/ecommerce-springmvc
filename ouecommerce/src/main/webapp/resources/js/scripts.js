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
    let doc = document.getElementById("spinner-loadquickview");
    doc.style.display = "block";
    document.getElementById("demo").remove();
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        doc.style.display = "none";
        console.log(data[0])
        let inner = "";
        let d = document.getElementById("modal-quickview")
        let fprice = (data[0].finalPrice).toLocaleString('en-US', {
            style: 'currency',
            currency: 'VND',
        });
        inner += `
                             <div id= "demo" class="card" style="width:100%">
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
function compareSalePost(endpoint)
{
    if (document.getElementById("cp-url").textContent == "") {
        let doc = document.getElementById("spinner-compare1");
        doc.style.display = "block";
        fetch(endpoint).then(function (res) {
            return res.json();
        }).then(function (data) {
            doc.style.display = "none";
            console.log(data[0]);
            let fprice = (data[0].finalPrice).toLocaleString('en-US', {
                style: 'currency',
                currency: 'VND',
            });
            document.getElementById("cp-name").innerText = data[0].title;
            document.getElementById("cp-origin").innerText = "Origin: " + data[0].origin;
            document.getElementById("cp-manufacturer").innerText = "Price: " + fprice;
            document.getElementById("cp-agency").innerText = "Agency: " + data[0].agencyID.name;
            document.getElementById("cp-url").innerText = endpoint;
            console.log(endpoint)
            localStorage.clear();
            localStorage.setItem("cp-name", data[0].title);
            localStorage.setItem("cp-origin", "Origin: " + data[0].origin);
            localStorage.setItem("cp-manufacturer", "Price: " + fprice);
            localStorage.setItem("cp-agency", "Agency: " + data[0].agencyID.name);
            localStorage.setItem("cp-url", endpoint);
            ;
        })
    } else {
        document.getElementById("btn-compare").click();
        if (document.getElementById("demo1") != null && document.getElementById("demo2") != null) {
            document.getElementById("demo1").remove();
            document.getElementById("demo2").remove();
        }
        let spinner1 = document.getElementById("spinner-item1");
        spinner1.style.display = "block";
        let spinner2 = document.getElementById("spinner-item2");
        spinner2.style.display = "block";
        var url = document.getElementById("cp-url").textContent;
        fetch(url).then(function (res) {
            return res.json();
        }).then(function (data) {
            spinner1.style.display = "none";
            console.log(data[0])
            let inner1 = "";
            let d1 = document.getElementById("item1-area")
            let fprice1 = (data[0].finalPrice).toLocaleString('en-US', {
                style: 'currency',
                currency: 'VND',
            });
            inner1 += `
                             <div id= "demo1" class="card" style="width:100%">
                             <div style="width:60%;margin-left:20%">
                            <img  style="width:100%"class="card-img-top" src="${data[0].avatar}" alt="Card image">
                             </div>
                            <div class="card-body row container-fluid">
                                <h4 class="text text-center fw-bold text-danger card-title"> ${data[0].title}</h4>
                                <h5 class="fw-bold text-center">Price: ${fprice1}</h5>
                                <div class="text text-center">
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
                                </div>
                            </div>
    `
            d1.innerHTML = inner1;


        })
        fetch(endpoint).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data[0])
            spinner2.style.display = "none";
            let inner2 = "";
            let d2 = document.getElementById("item2-area")
            let fprice2 = (data[0].finalPrice).toLocaleString('en-US', {
                style: 'currency',
                currency: 'VND',
            });
            inner2 += `
                             <div id= "demo2" class="card" style="width:100%">
                             <div style="width:60%;margin-left:20%">
                            <img  style="width:100%"class="card-img-top" src="${data[0].avatar}" alt="Card image">
                             </div>
                            <div class="card-body row container-fluid">
                                <h4 class="text text-center fw-bold text-danger card-title"> ${data[0].title}</h4>
                                <h5 class="fw-bold text-center">Price: ${fprice2}</h5>
                                <div class="text text-center">
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
                                </div>
                            </div>
    `
            d2.innerHTML = inner2;

        })
        document.getElementById("cp-name").innerText = "";
        document.getElementById("cp-origin").innerText = "";
        document.getElementById("cp-manufacturer").innerText = "";
        document.getElementById("cp-agency").innerText = "";
        document.getElementById("cp-url").innerText = "";
        localStorage.clear();
    }
}
function clearItem() {
    document.getElementById("cp-name").innerText = "";
    document.getElementById("cp-origin").innerText = "";
    document.getElementById("cp-manufacturer").innerText = "";
    document.getElementById("cp-agency").innerText = "";
    document.getElementById("cp-url").innerText = "";
    localStorage.clear();
}
window.addEventListener('load', function () {
    document.getElementById("cp-name").innerText = localStorage.getItem("cp-name");
    document.getElementById("cp-origin").innerText = localStorage.getItem("cp-origin");
    document.getElementById("cp-manufacturer").innerText = localStorage.getItem("cp-manufacturer");
    document.getElementById("cp-agency").innerText = localStorage.getItem("cp-agency");
    document.getElementById("cp-url").innerText = localStorage.getItem("cp-url");
})

function addToWishList(username,signin){
    if (username == "") {
        window.location.href = signin;
    }
}