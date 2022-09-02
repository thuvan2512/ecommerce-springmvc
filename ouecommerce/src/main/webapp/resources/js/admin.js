/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function viewDetailAgency(endpoint) {
    let doc = document.getElementById("sp-load-quickview-agency");
    doc.style.display = "block";
    var area = document.getElementById("view-detail-agency-area");
    area.innerHTML = "";
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        doc.style.display = "none";
        console.log(data[0])
        let inner = "";
        inner += `
<div style="width:60%;margin-left:20%">
                        <img  style="width:100%"class="card-img-top" src="${data.avatar}" alt="Card image">
                    </div>
                    <div class="card-body row container-fluid">
                        <h4 class="text text-center text-uppercase fw-bold text-danger card-title">${data.name}</h4>
                        <div class="text text-center">
                            <h5><span  class="fw-bold">Created date: </span>${moment(data.createdDate).fromNow()}</h5> 
                            <h5><span  class="fw-bold">Agency field: </span> ${data.field.name}</h5>
                            <h5><span  class="fw-bold">Hotline: </span> ${data.hotline}</h5>
                            <h5><span class="fw-bold">Address: </span> ${data.address}</h5>
                        </div>
                    </div>
    `
        area.innerHTML = inner;

    }).catch(err => console.error(err))
}

function deleteAgency(endpoint, agencyID, obj) {
    if (confirm("Are you sure you want to delete this agency?") == true) {
        obj.style.display = "none";
        document.getElementById(`sp-wait-delete-agency-${agencyID}`).style.display = "block";
        document.getElementById(`btn-accept-agency-${agencyID}`).disabled = true;
        fetch(endpoint, {
            method: 'delete',
            body: JSON.stringify({
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            if (data == "NO_CONTENT") {
                alert("Delete agency successful !!!")
                document.getElementById(`censorship-agency-${agencyID}`).remove()
            } else {
                obj.style.display = "block";
                document.getElementById(`sp-wait-delete-agency-${agencyID}`).style.display = "none";
                document.getElementById(`btn-accept-agency-${agencyID}`).disabled = false;
                alert("Delete failed !!!")
            }
        }).catch(err => console.log(err))
    }
}
function censorshipAgency(endpoint, agencyID, obj) {
    if (confirm("Are you sure you want to accept this agency?") == true) {
        obj.style.display = "none";
        document.getElementById(`sp-wait-delete-agency-${agencyID}`).style.display = "block";
        document.getElementById(`btn-delete-agency-${agencyID}`).disabled = true;
        fetch(endpoint, {
            method: 'put',
            body: JSON.stringify({
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            if (data == "OK") {
                alert("Accept agency successful !!!")
                document.getElementById(`censorship-agency-${agencyID}`).remove()
            } else {
                obj.style.display = "block";
                document.getElementById(`sp-wait-delete-agency-${agencyID}`).style.display = "none";
                document.getElementById(`btn-delete-agency-${agencyID}`).disabled = false;
                alert("Accept failed !!!")
            }
        }).catch(err => console.log(err))
    }
}

function banAgency(endpoint, agencyID, obj) {
    if (confirm("Are you sure you want to ban this agency?") == true) {
        obj.style.display = "none";
        document.getElementById(`btn-view-detail-agency-stats-${agencyID}`).disabled = true;
        document.getElementById(`sp-wait-ban-agency-${agencyID}`).style.display = "block";
        fetch(endpoint).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            if (data == "OK") {
                alert("Ban agency successful !!!")
                document.getElementById(`agency-${agencyID}`).remove()
            } else {
                obj.style.display = "block";
                document.getElementById(`sp-wait-ban-agency-${agencyID}`).style.display = "none";
                document.getElementById(`btn-view-detail-agency-stats-${agencyID}`).disabled = false;
                alert("Ban failed !!!")
            }
        }).catch(err => console.log(err))
    }
}
function unbanAgency(endpoint, agencyID, obj) {
    if (confirm("Are you sure you want to un ban this agency?") == true) {
        obj.style.display = "none";
        document.getElementById(`btn-view-detail-agency-stats2-${agencyID}`).disabled = true;
        document.getElementById(`sp-wait-unban-agency-${agencyID}`).style.display = "block";
        fetch(endpoint).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            if (data == "OK") {
                alert("Un ban agency successful !!!")
                document.getElementById(`banned-agency-${agencyID}`).remove()
            } else {
                obj.style.display = "block";
                document.getElementById(`sp-wait-unban-agency-${agencyID}`).style.display = "none";
                document.getElementById(`btn-view-detail-agency-stats2-${agencyID}`).disabled = false;
                alert("Ban failed !!!")
            }
        }).catch(err => console.log(err))
    }
}
function changeStateOrder(endpoint) {
    document.getElementById("input-orderid-area").value = endpoint;
}
function changeStateOrderSubmit(obj) {
    var endpoint = document.getElementById("input-orderid-area").value;
    var state = document.getElementById("select-order-state").value;
    if (state != 0) {
        document.getElementById("sp-wait-order-in-modal").style.display = "block";
        obj.disabled = true;
        var fetchEnpoint = `${endpoint}${state}`;
         fetch(fetchEnpoint).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            obj.disabled = false;
            document.getElementById("sp-wait-order-in-modal").style.display = "none";
            if (data == "OK") {
                alert("Change state order successful !!!")
                location.reload();
            }
        }).catch(err => console.log(err))
    }else {
        alert("Must choose a state !!!");
    }

}

function deleteOrder(obj, endpoint, orderID) {
    if (confirm("Are you sure you want to cancel this order?") == true) {
        document.getElementById(`sp-wait-change-delete-order-${orderID}`).style.display = "block";
        obj.style.display = "none";
        fetch(endpoint, {
            method: 'delete',
            body: JSON.stringify({
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            console.log(data);
            obj.style.display = "block";
            document.getElementById(`sp-wait-change-delete-order-${orderID}`).style.display = "none";
            if (data == "NO_CONTENT") {
                alert("Delete order successful !!!")
                document.getElementById(`order-area-${orderID}`).remove()
            } else {
                alert("Delete failed !!!")
            }
        }).catch(err => console.log(err))
    }
}