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
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
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
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
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
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
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

function addToCart(context) {
    var classify = document.getElementById("select-item");
    var qtyInput = document.getElementById("qty");
    if (classify != null) {
        if (classify.value != "0" && qtyInput.value != 0) {
            var url = context + classify.value + "/" + qtyInput.value + "/";
            let cartQty = document.getElementById("cart-qty");
            fetch(url).then(res => res.json()).then(data => {
                if (cartQty != null) {
                    cartQty.innerText = data;
                    qtyInput.value = null;
                    document.getElementById("btn-addtocart").disabled = true;
                    document.getElementById("qty-instock").innerText = "";
                    document.getElementById("spinner-qty-instock").style.display = "block";
                    document.getElementById("btn-close-addtocart").click();
                }
            })
        }
    }
}
function disableButtonAddToCart() {
    document.getElementById("btn-addtocart").disabled = true;
    document.getElementById("qty-instock").innerText = "";
    document.getElementById("spinner-qty-instock").style.display = "block";
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
function addCommentPost(endpoint) {
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
            console.log(data[0]);
        }).catch(err => console.log(err))
        setTimeout(reload, 500);

    } else {
        alert("Comment failed !!!")
    }
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
                                <h6><span  class="fw-bold">Shop:</span> ${data[0].agencyID.name}</h6>
                                <h6><span  class="fw-bold">Category:</span> ${data[0].categoryID.name}</h6> 
                                <h6><span class="fw-bold">Origin:</span> ${data[0].origin}</h6>
                                <h6><span  class="fw-bold">Brand:</span> ${data[0].brand}</h6>
                                <h6><span  class="fw-bold">Manufacturer:</span> ${data[0].manufacturer}</h6>
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
let maxQuantity;
function checkQty(context) {
    document.getElementById("btn-addtocart").disabled = true;
    var classify = document.getElementById("select-item");
    var spinnerQty = document.getElementById("spinner-qty-instock");
    spinnerQty.style.display = "block";
    if (classify.value != "0") {
        fetch(`${context}api/getQty/${classify.value}/`).then(function (res) {
            return res.json();
        }).then(function (data) {
            spinnerQty.style.display = "none";
            document.getElementById("qty-instock").innerText = data;
            document.getElementById("qty").max = data;
            maxQuantity = data;
            if (data == 0) {
                document.getElementById("qty").value = 0;
            } else {
                document.getElementById("qty").value = 1;
            }
            if (document.getElementById("qty").value > 0 && document.getElementById("qty").value <= data) {
                document.getElementById("btn-addtocart").disabled = false;
            } else {
                document.getElementById("btn-addtocart").disabled = true;
            }
        }).catch(err => console.error(err))
    } else {
        document.getElementById("qty-instock").innerText = "";
        document.getElementById("qty").max = 100;
        document.getElementById("btn-addtocart").disabled = true;
    }
}
function validateQty() {
    var qtyInput = document.getElementById("qty");
    if (qtyInput != null) {
        if (qtyInput.value > maxQuantity) {
            qtyInput.value = maxQuantity;
        }
        if (qtyInput.value <= 0) {
            if (maxQuantity == 0) {
                qtyInput.value = 0;
            } else {
                qtyInput.value = 1;
            }
        }
    }
    if (qtyInput.value > 0 && qtyInput.value <= maxQuantity) {
        document.getElementById("btn-addtocart").disabled = false;
    } else {
        document.getElementById("btn-addtocart").disabled = true;
    }
}

function updateCart(object, endpoint, getNewQty, getNewTotal,getNewTotalItem,getItemQty,itemID) {
    if (object.value == null) {
        object.value = 1;
    }
    document.getElementById("sp-cart-total-price").style.display = "block";
    fetch(`${endpoint}${object.value}/`, {
        method: 'put',
        body: JSON.stringify({
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(function (res) {
        return res;
    }).then(function (data) {
        fetch(getNewTotal).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data);
            document.getElementById("sp-cart-total-price").style.display = "none";
            var totalPrice = data.toLocaleString('it-IT', {
                style: 'currency',
                currency: 'VND',
            });
            document.getElementById("cart-total").innerText = totalPrice;
        }).catch(err => console.error(err));
        fetch(getNewQty).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data);
            document.getElementById("cart-qty").innerText = data;
        }).catch(err => console.error(err));
        fetch(getItemQty).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data);
            object.value = data;
        }).catch(err => console.error(err));
        fetch(getNewTotalItem).then(function (res) {
            return res.json();
        }).then(function (data) {
            console.log(data);
            var totalPriceItem = data.toLocaleString('it-IT', {
                style: 'currency',
                currency: 'VND',
            });
            document.getElementById(`total-item-${itemID}`).innerText = totalPriceItem;
        }).catch(err => console.error(err));
    }).catch(err => console.error(err))
}

function deleteCart(endpoint, cartID, getNewQty, getNewTotal, countItems) {
    if (confirm("Are you sure you want to remove this item from the cart?") == true) {
        event.preventDefault();
        document.getElementById(`sp-delcart-${cartID}`).style.display = "block";
        document.getElementById("sp-cart-total-price").style.display = "block";
        document.getElementById(`btn-delcart-${cartID}`).style.display = "none";
        console.log(`cart${cartID}`);
        fetch(endpoint, {
            method: 'delete',
            body: JSON.stringify({
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res;
        }).then(function (data) {
            document.getElementById(`cart${cartID}`).remove();
            console.log(data);
            fetch(getNewQty).then(function (res) {
                return res.json();
            }).then(function (data) {
                console.log(data);
                document.getElementById("cart-qty").innerText = data;
            }).catch(err => console.error(err));
            fetch(countItems).then(function (res) {
                return res.json();
            }).then(function (data) {
                console.log(data);
                document.getElementById("cart-count-items").innerText = data;
            }).catch(err => console.error(err));
            fetch(getNewTotal).then(function (res) {
                return res.json();
            }).then(function (data) {
                console.log(data);
                document.getElementById("sp-cart-total-price").style.display = "none";
                var totalPrice = data.toLocaleString('it-IT', {
                    style: 'currency',
                    currency: 'VND',
                });
                document.getElementById("cart-total").innerText = totalPrice;
            }).catch(err => console.error(err));
        }).catch(err => console.error(err));
//        setTimeout(reload, 200);
    }
}
function payment(endpoint, context) {
    if (confirm("Are you sure you want to create this order?. After you confirm, an email will be sent to you from the system") == true) {
        var type = document.querySelector('input[name="rdPaymentType"]:checked').value;
        fetch(endpoint, {
            method: 'post',
            body: JSON.stringify({
                'paymentType': type,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            if (data == "OK") {
                alert("Please check your mailbox and reply to us as soon as possible if you have any problem !!!")
                location.reload();
            } else {
                alert("Failed !!!")
            }
        }).catch(err => console.log(err))
    }
}