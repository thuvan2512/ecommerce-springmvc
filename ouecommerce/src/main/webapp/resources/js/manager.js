
function publishSalePost(endpoint, salepostID) {
    if (confirm("Are you sure you want to publish this post?") == true) {
        fetch(endpoint).then(function (res) {
            return res.json()
        }).then(function (data) {
            if (data == "OK") {
                alert("Publish sale post successful !!!")
                document.getElementById(`unpublished-salepost-${salepostID}`).remove()
            } else {
                alert("Item list is empty, you must add item !!!")
            }
        }).catch(err => console.log(err))
    }
}

function unpublishSalePost(endpoint, salepostID) {
    if (confirm("Are you sure you want to unpublished this post?") == true) {
        fetch(endpoint).then(function (res) {
            return res.json()
        }).then(function (data) {
            if (data == "OK") {
                alert("Unpublished sale post successful !!!")
                document.getElementById(`unpublished-salepost-${salepostID}`).remove()
            } else {
                alert("Unpublish failed !!!")
            }
        }).catch(err => console.log(err))
    }
}
function deleteSalePost(obj, endpoint, postID) {
    if (confirm("Are you sure you want to delete this post?") == true) {
        obj.disabled = true;
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
            obj.disabled = false;
            if (data == "NO_CONTENT") {
                alert("Delete sale post successful !!!")
                document.getElementById(`unpublished-salepost-${postID}`).remove()
            } else {
                alert("Delete failed !!!")
            }
        }).catch(err => console.log(err))
    }
}

function addItemForSalePost(endpoint) {
    document.getElementById("btn-open-add-item").click();
    document.getElementById("salepostID").value = endpoint;
}
function addItem(obj) {
    document.getElementById("sp-add-item-1").style.display = "block";
    obj.disabled = true;
    var endpoint = document.getElementById("salepostID").value
    var formData = new FormData();
    var fileAvatar = document.getElementById("item-avatar");
    document.getElementById("error-item-name").innerHTML = ""
    document.getElementById("error-item-unitPrice").innerHTML = ""
    document.getElementById("error-item-inventory").innerHTML = ""
    document.getElementById("error-item-description").innerHTML = ""
    if (fileAvatar.files[0] != null) {
        formData.append("avatarFile", fileAvatar.files[0]);
        formData.append("item", new Blob([JSON.stringify({
                "name": document.getElementById("item-name").value,
                "unitPrice": document.getElementById("item-unitPrice").value,
                "inventory": document.getElementById("item-inventory").value,
                "description": document.getElementById("item-description").value,
            })], {
            type: "application/json"
        }))
        console.log(fileAvatar.files[0])
        if (endpoint != "") {
            fetch(endpoint, {
                method: "POST",
                body: formData
            }).then(res => res.json()).then(data => {
                console.log(data);
                document.getElementById("sp-add-item-1").style.display = "none";
                obj.disabled = false;
                if (Object.keys(data).length === 0) {
                    alert("Add item sucessful");
                    location.reload();
                } else {
                    $.each(data, function (key, value) {
                        document.getElementById(`error-item-${key}`).innerHTML = `<span class="text-danger">${value}</span>`;
                    });
                }
            }).catch(err => {
                console.error(err)
            })
        }
    } else {
        alert("The avatar file cannot be left blank")
        document.getElementById("sp-add-item-1").style.display = "none";
        obj.disabled = false;
    }

}
function updateItemForSalePost(endpoint, getItem) {
    document.getElementById("sp-update-item-1").style.display = "none";
    document.getElementById("btn-update-item").disabled = false;
    document.getElementById("btn-open-update-item").click();
    document.getElementById("sp-load-item-update").style.display = "block";
    document.getElementById("area-itemID").value = endpoint;
    document.getElementById("error-update-item-name").innerHTML = ""
    document.getElementById("error-update-item-unitPrice").innerHTML = ""
    document.getElementById("error-update-item-inventory").innerHTML = ""
    document.getElementById("error-update-item-description").innerHTML = ""
    fetch(getItem).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        document.getElementById("sp-load-item-update").style.display = "none";
        document.getElementById("img-avatar-item-area").innerHTML = `
<img style="margin-left: 40%" src="${data.avatar}" width="100" height="100" alt="alt"/>    
`
        document.getElementById("item-update-name").value = data.name;
        document.getElementById("item-update-unitPrice").value = data.unitPrice;
        document.getElementById("item-update-inventory").value = data.inventory;
        document.getElementById("item-update-description").value = data.description;
    }).catch(err => {
        console.error(err)
    })
}
function updateItem(obj) {
    document.getElementById("sp-update-item-1").style.display = "block";
    obj.disabled = true;
    var endpoint = document.getElementById("area-itemID").value
    var formDataUpdate = new FormData();
    var fileAvatar = document.getElementById("item-update-avatar");
    document.getElementById("error-update-item-name").innerHTML = ""
    document.getElementById("error-update-item-unitPrice").innerHTML = ""
    document.getElementById("error-update-item-inventory").innerHTML = ""
    document.getElementById("error-update-item-description").innerHTML = ""
    if (fileAvatar.files[0] != null) {
        formDataUpdate.append("avatarFileUpdate", fileAvatar.files[0]);
    }
    formDataUpdate.append("updateItem", new Blob([JSON.stringify({
            "name": document.getElementById("item-update-name").value,
            "unitPrice": document.getElementById("item-update-unitPrice").value,
            "inventory": document.getElementById("item-update-inventory").value,
            "description": document.getElementById("item-update-description").value,
        })], {
        type: "application/json"
    }))
    console.log(fileAvatar.files[0])
    if (endpoint != "") {
        fetch(endpoint, {
            method: "POST",
            body: formDataUpdate
        }).then(res => res.json()).then(data => {
            console.log(data);
            document.getElementById("sp-update-item-1").style.display = "none";
            obj.disabled = false;
            if (Object.keys(data).length === 0) {
                alert("Update item sucessful");
                location.reload();
            } else {
                $.each(data, function (key, value) {
                    document.getElementById(`error-update-item-${key}`).innerHTML = `<span class="text-danger">${value}</span>`;
                });
            }
        }).catch(err => console.log(err))
    }

}
function openModalUpLoadMultiple(endpoint) {
    document.getElementById("btn-open-modal-upload-multiple").click();
    document.getElementById("endpoint-to-upload-multiple").value = endpoint;
}
function uploadPictureSet(obj) {
    var inputFile = document.getElementById("picture-set-input");
    if (inputFile.files.length != 0) {
        obj.disabled = true;
        document.getElementById("sp-upload-pic-set").style.display = "block";
        var endpoint = document.getElementById("endpoint-to-upload-multiple").value
        var formData = new FormData();
        for (var file of inputFile.files) {
            formData.append("files", file);
        }
        fetch(endpoint, {
            method: "POST",
            body: formData
        }).then(res => res).then(data => {
            obj.disabled = true;
            document.getElementById("sp-upload-pic-set").style.display = "block";
            console.log(data);
            alert("Upload picture set successful !!!")
            location.reload();
        }).catch((error) => ("Something went wrong!", error));
    } else {
        alert("Must choose file to upload")
    }

}
function deleteImageSalePost(obj, endpoint, picID) {
    if (confirm("Are you sure you want to delete this picture?") == true) {
        obj.disabled = true;
        document.getElementById(`sp-delete-pic-post-${picID}`).style.display = "block";
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
            obj.disabled = false;
            document.getElementById(`sp-delete-pic-post-${picID}`).style.display = "none";
            if (data == "NO_CONTENT") {
                document.getElementById(`picture-salepost-${picID}`).remove()
            } else {
                alert("Delete failed !!!")
            }
        }).catch(err => console.log(err))
    }
}
function deleteItemSalePost(obj, endpoint, itemID) {
    if (confirm("Are you sure you want to delete this item?") == true) {
        obj.disabled = true;
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
            obj.disabled = false;
            if (data == "NO_CONTENT") {
                alert("Delete item successful !!!")
                document.getElementById(`item-salepost-${itemID}`).remove()
            } else {
                if (data == "CONFLICT") {
                    alert("Unpublish the sale post before removing the last item!!!")
                } else {
                    alert("Delete failed !!!")
                }
            }
        }).catch(err => console.log(err))
    }
}
function toggleButtonClick(obj) {
    if (obj.classList.contains("active") == true) {
        obj.classList.remove("active");
    } else {
        obj.classList.add("active");
    }
}