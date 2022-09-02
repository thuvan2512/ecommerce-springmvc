
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

function updateCart(object, endpoint, getNewQty, getNewTotal, getNewTotalItem, getItemQty, itemID) {
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