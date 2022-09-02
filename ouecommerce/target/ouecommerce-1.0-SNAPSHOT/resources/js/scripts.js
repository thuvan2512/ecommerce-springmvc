/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onscroll = function () {
    scrollFunction()
};
window.addEventListener('load', function () {
    try {
        document.getElementById("cp-name").innerText = localStorage.getItem("cp-name");
        document.getElementById("cp-origin").innerText = localStorage.getItem("cp-origin");
        document.getElementById("cp-manufacturer").innerText = localStorage.getItem("cp-manufacturer");
        document.getElementById("cp-agency").innerText = localStorage.getItem("cp-agency");
        document.getElementById("cp-url").innerText = localStorage.getItem("cp-url");
    } catch (e) {
    }
})
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
    if (document.getElementById("demo") != null) {
        document.getElementById("demo").remove();
    }
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        doc.style.display = "none";
        console.log(data[0])
        let inner = "";
        let d = document.getElementById("modal-quickview")
        let fprice = (data[0].finalPrice).toLocaleString('it-IT', {
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
                                <h5><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h5>
                                <h5><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h5> 
                                <h5><span class="fw-bold">Origin:</span> ${data[0].origin}</h5>
                                <h5><span  class="fw-bold">Brand:</span> ${data[0].brand}</h5>
                                <h5><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h5>
                                </div>
                            </div>
    `
        d.innerHTML = inner;

    }).catch(err => console.error(err))
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
            let fprice = (data[0].finalPrice).toLocaleString('it-IT', {
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
        }).catch(err => console.error(err))
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
            let fprice1 = (data[0].finalPrice).toLocaleString('it-IT', {
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
                                <h5><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h5>
                                <h5><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h5> 
                                <h5><span class="fw-bold">Origin:</span> ${data[0].origin}</h5>
                                <h5><span  class="fw-bold">Brand:</span> ${data[0].brand}</h5>
                                <h5><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h5>
                                </div>
                            </div>
    `
            d1.innerHTML = inner1;


        }).catch(err => console.error(err))
        fetch(endpoint).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data[0])
            spinner2.style.display = "none";
            let inner2 = "";
            let d2 = document.getElementById("item2-area")
            let fprice2 = (data[0].finalPrice).toLocaleString('it-IT', {
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
                                <h5><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h5>
                                <h5><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h5> 
                                <h5><span class="fw-bold">Origin:</span> ${data[0].origin}</h5>
                                <h5><span  class="fw-bold">Brand:</span> ${data[0].brand}</h5>
                                <h5><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h5>
                                </div>
                            </div>
    `
            d2.innerHTML = inner2;

        }).catch(err => console.error(err))
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

function addToWishList(obj, username, signin, postID, endpoint) {
    if (username == "") {
        window.location.href = signin;
    } else {
        fetch(endpoint, {
            method: 'post',
            body: JSON.stringify({
                'postID': postID,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data)
            if (data == 1) {
                obj.style.color = "#D10024";
                alert("Add to wish list !!!");
            }
            if (data == 0) {
                obj.style.color = "#000000";
                alert("Remove from wish list !!!");
            }
        }).catch(err => console.log(err))
    }
}
function removeFromWishlist(endpoint, postID, obj) {
    event.preventDefault();
    document.getElementById(`sp-delete-${postID}`).style.display = "block";
    obj.style.display = "none";
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            'postID': postID,
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        console.log(data)
        if (data == 0) {
            if (document.getElementById(`salepost-in-wishlist-${postID}`) != null) {
                document.getElementById(`salepost-in-wishlist-${postID}`).remove();
            }
        }
    }).catch(err => console.log(err))
}
function change_image(image) {

    var container = document.getElementById("main-image");

    container.src = image.src;
}

function clearRate() {
    var starRatePost = document.querySelector('input[name="rating-post"]:checked');
    if (starRatePost != null) {
        starRatePost.checked = false;
    }
//    console.log(starRatePost.value);
}
function reload() {
    location.reload();
}
function loadClassify(endpointPost, endpointClassify, context) {
    if (document.getElementById("demo3") != null) {
        document.getElementById("demo3").remove();
    }
    let spinner3 = document.getElementById("spinner-item3");
    spinner3.style.display = "block";
    let spinner4 = document.getElementById("spinner-item4");
    spinner4.style.display = "block";
    if (document.getElementById("select-item") != null) {
        document.getElementById("select-item").remove();
    }
    fetch(endpointPost).then(function (res) {
        return res.json();
    }).then(function (data) {
        spinner3.style.display = "none";
        console.log(data[0])
        let inner3 = "";
        let d3 = document.getElementById("item3-area")
        let fprice3 = (data[0].finalPrice).toLocaleString('it-IT', {
            style: 'currency',
            currency: 'VND',
        });
        inner3 += `
                             <div id= "demo3" class="card" style="width:100%">
                             <div style="width:60%;margin-left:20%">
                            <img  style="width:100%"class="card-img-top" src="${data[0].avatar}" alt="Card image">
                             </div>
                            <div class="card-body row container-fluid">
                                <h4 class="text text-center fw-bold text-danger card-title"> ${data[0].title}</h4>
                                <h5 class="fw-bold text-center">Price: ${fprice3}</h5>
                                <div class="text text-center">
                                <h5><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h5>
                                <h5><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h5> 
                                <h5><span class="fw-bold">Origin:</span> ${data[0].origin}</h5>
                                <h5><span  class="fw-bold">Brand:</span> ${data[0].brand}</h5>
                                <h5><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h5>
                                </div>
                            </div>
    `
        d3.innerHTML = inner3;


    }).catch(err => console.error(err))
    fetch(endpointClassify).then(function (res) {
        return res.json();
    }).then(function (data) {
        spinner4.style.display = "none";
        console.log(data[0])
        let inner4 = "";
        let innerValue4 = "";
        let d4 = document.getElementById("item4-area")
        for (let i = 0; i < data.length; i++) {
            innerValue4 += `
            <option value="${data[i].itemID}">${data[i].name}&nbsp;-&nbsp;${data[i].description}</option>
    `

        }
        inner4 += `
                    <select id="select-item" onchange="checkQty('${context}')" style="margin-top: 30px;margin-bottom: 30px" class="form-select form-select-sm" aria-label=".form-select-sm example">
                        <option value="0" selected class="fw-bold">Choose an item</option>
                        ${innerValue4}
                    </select>
            
`
        d4.innerHTML = inner4;


    })
}
function addCommentPost(endpoint, starAvg) {
    console.log(endpoint);
    let cmtContent = document.getElementById("cmtPost").value;
    var numStar;
    var starPost = document.querySelector('input[name="rating-post"]:checked');
    if (starPost == null) {
        numStar = 0;
    } else {
        numStar = starPost.value;
    }
    if (numStar != 0 || cmtContent != "") {
        fetch(endpoint, {
            method: 'post',
            body: JSON.stringify({
                'star': numStar,
                'content': cmtContent
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {

            fetch(starAvg).then(function (res) {
                return res.json();
            }).then(function (data) {
                console.log(data);
                var fullStar = "";
                for (var i = 0; i < data.star; i++) {
                    fullStar += `
    <i class="rate fas fa-star"></i>
`
                }
                for (var j = 0; j < data.haftStar; j++) {
                    fullStar += `
    <i class="rate fas fa-star-half-alt"></i>
`
                }
                for (var k = 0; k < data.nonStar; k++) {
                    fullStar += `
    <i class="rate far fa-star"></i>
`
                }
                document.getElementById("count-rating").innerText = parseFloat(data.review).toFixed(0);
                document.getElementById("rating-avg").innerText = parseFloat(data.starAvg).toFixed(2);
                document.getElementById("star-rating-avg").innerHTML = fullStar;
            }).catch(err => console.log(err))

            console.log(data);
            var star = "";
            if (data.starRate != null) {
                for (var i = 0; i < data.starRate; i++) {
                    star += `<i class="rate fas fa-star"></i> `
                }
                for (var i = 0; i < 5 - data.starRate; i++) {
                    star += `<i class="rate far fa-star"></i>`
                }
            }
            var cmt_area = document.getElementById("cmt-area").outerHTML;
            cmt_area += `
                <div class="d-flex flex-row p-3"> <img src="${data.userID.avatar}" width="40" height="40" class="rounded-circle mr-3">&nbsp;
                                            <div class="w-100">
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <div class="d-flex flex-row align-items-center"> <span class="mr-2 fw-bold">${data.userID.username}</span> &nbsp;<small class="c-badge">Top Comment</small> </div>
                                                </div>
                                                <p class="text-justify comment-text mb-0"><em>${data.content}</em></p>
                                                <c:if test="${data.starRate > 0}">
                                                    <div class="product-rating">
                                                ${star}
                                                    </div>
                                                </c:if>

                                                <div class="d-flex flex-row user-feed">
                                                <small class="cmt-date">${moment(data.createdDate).fromNow()}</small>
                                                </div>
                                            </div>
                                        </div>
            
`
            document.getElementById("cmt-area").innerHTML = cmt_area;
            var starRatePost = document.querySelector('input[name="rating-post"]:checked');
            if (starRatePost != null) {
                starRatePost.checked = false;
            }
            document.getElementById("cmtPost").value = "";
            var notify = document.getElementById("notify-null-cmt");
            if (notify != null) {
                notify.remove();
            }
        }).catch(err => console.log(err))

    } else {
        alert("Comment failed !!!")
    }
}

function redirectToUrl(url) {
    window.location.href = url;
}

function viewDetailOrder(endpoint, totalPrice) {
    document.getElementById("sp-load-item-order").style.display = "block";
    document.getElementById("modal-area-item-order").innerHTML = "";
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        var inner = "";
        document.getElementById("sp-load-item-order").style.display = "none";
        for (var i = 0; i < data.length; i++) {
            var uf = (data[i].itemID.unitPrice).toLocaleString('it-IT', {
                style: 'currency',
                currency: 'VND',
            });
            var tf = (data[i].itemID.unitPrice * data[i].quantity).toLocaleString('it-IT', {
                style: 'currency',
                currency: 'VND',
            });
            inner += `
    <div class="row justify-content-center mb-3">
    <div class="col-md-12 col-xl-10">
        <div class="card shadow-0 border rounded-3">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                        <div class="bg-image hover-zoom ripple rounded ripple-surface">
                            <img src="${data[i].itemID.avatar}"
                                 class="w-100 h-100" />
                            <a href="#!">
                                <div class="hover-overlay">
                                    <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-5 col-xl-5">
                        <h5 class="fw-bold">${data[i].itemID.name}</h5>
                        <h5>${uf}</h5>
                        <h5>Qty: ${data[i].quantity}</h5>
                        <h5>${data[i].itemID.description}</h5>
                        <h5>Customer: ${data[i].orderID.userID.username}</h5>
                    </div>
                    <div class="col-md-6 col-lg-4 col-xl-4 border-sm-start-none border-start">
                        <h5 class="text-dark fw-bold">Temporary Price</h5>
                        <div class="d-flex flex-row align-items-center mb-1">
                            <h5 class="mb-1 me-1 fw-bold text-danger">${tf}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`
        }
        inner += `
            <div class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <h4>Total Price:<span class="fw-bold text-danger"> ${totalPrice} VND </span></h4>
                </div>
            </div>
`
        document.getElementById("modal-area-item-order").innerHTML = inner;
    }).catch(err => console.log(err))
}
