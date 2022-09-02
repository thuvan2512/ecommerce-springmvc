<%-- 
    Document   : manager
    Created on : 21 Aug 2022, 09:39:28
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row">
    <div class="col-md-3 col-3">
        <div style="position: fixed;height: 100%;width: 300px"class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
            <a href="<c:url value="/manager/home"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <img class="img-fluid" style="margin-right: 10%" src="<c:url value="/images/logo/logobanner.png"/>" width="80%" alt="logo"/>
            </a>
            <hr>
            <div class="dropdown">
                <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="${currentUser.avatar}" alt="" width="40" height="40" class="rounded-circle me-2">
                    &nbsp;<strong>${currentUser.username}</strong>
                </a>
                <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1" style="">
                    <li><a class="dropdown-item" href="<c:url value="/user/profile"/>">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="<c:url value="/logout"/>">Sign out</a></li>
                </ul>
            </div>
            <hr/>
            <ul class="nav nav-pills flex-column mb-auto">
                <li>
                    <a href="<c:url value="/manager/home"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-eye"></i>&nbsp;
                        Overview
                    </a>
                </li>  
                <li>
                    <a href="<c:url value="/manager/notifications"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-bell"></i>&nbsp;
                        Notifications
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/manager/edit-agency"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-pen-alt"></i>&nbsp;
                        Edit Agency Info
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/manager/orders"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-box"></i>&nbsp;
                        Orders
                    </a>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse2" aria-expanded="false">
                        <i class="fas fa-th"></i>&nbsp;
                        Products &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse2" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="<c:url value="/manager/add-product"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">New Products</a></li>
                            <li><a href="<c:url value="/manager/unpublished-products"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Unpublished Products</a></li>
                            <li><a href="<c:url value="/manager/published-products"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Published Products</a></li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse1" aria-expanded="false">
                        <i class="fas fa-chart-area"></i>&nbsp;
                        Statistics &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse1" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="<c:url value="/manager/general-stats"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">General Statistics</a></li>
                            <li><a href="<c:url value="/manager/revenue-stats"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Revenue Statistics</a></li>
                        </ul>
                    </div>
                </li>
                <hr/>
                <li>
                    <a href="<c:url value="/"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-backspace"></i>&nbsp;
                        Go Back
                    </a>
                </li>

            </ul>
        </div>
    </div>
    <div class="row col-md-9 col-9">
        <tiles:insertAttribute name="managerContent"/>                      
    </div>

</div>
<!-- modal add item -->
<!-- comment -->
<div class="modal fade" id="modal-add-item">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">Add Items</span></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div class="row col-md-12 col-12">
                    <div class=" text-black">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-8 col-xl-8 order-2 order-lg-1">

                                    <form id="form-add-item" cssClass="mx-1 mx-md-4" method="post" enctype="multipart/form-data">
                                        <input style="display: none" id="salepostID" type="text" value="">
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="fileAvatar" id="item-avatar" type = "file" class="form-control"/>
                                                <label class="fw-bold form-label" for="item-avatar">Avatar</label>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-heading fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="name" id="item-name"type = "text" class="form-control"/>
                                                <div id="error-item-name"></div>
                                                <label class="fw-bold form-label" for="item-name">Name</label>

                                            </div>
                                        </div>
                                        <div class="row d-flex flex-row align-items-center mb-2">
                                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                                <i class="fas fa-box fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <input name="inventory" id="item-inventory" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');" step="1" min="0" type = "number" class="form-control"/>
                                                    <div id="error-item-inventory"></div>
                                                    <label class="fw-bold form-label" for="item-inventory">Inventory</label>

                                                </div>
                                            </div>
                                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <input name="unitPrice" id="item-unitPrice"type = "number" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');" step="1" min="0" class="form-control"/>
                                                    <div id="error-item-unitPrice"></div>
                                                    <label class="fw-bold form-label" for="item-unitPrice">Unit Price</label>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-info fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="description" id="item-description" type = "text" class="form-control"/>
                                                <div id="error-item-description"></div>
                                                <label class="fw-bold form-label" for="item-description">Description</label>

                                            </div>
                                        </div>
                                        <div id="sp-add-item-1" style="display: none" class="spinner-border"></div>
                                        <button type="button" onclick="addItem(this)" class="w-100 py-2 mb-2 btn btn-dark">
                                            Add Item
                                        </button>
                                    </form>

                                </div>
                                <button style="display: none" id="btn-open-add-item" data-bs-toggle="modal" data-bs-target="#modal-add-item" ></button>
                                <div class="col-md-10 col-lg-4 col-xl-4 d-flex align-items-center order-1 order-lg-2">

                                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661238920/Usability_testing-pana_zyjjh5.png"
                                         class="img-fluid" alt="Sample image">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<!-- modal upload multiple file -->
<!-- Button to Open the Modal -->
<button style="display: none" id="btn-open-modal-upload-multiple" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-upload-multiple">
    Open modal
</button>
<!-- The Modal -->
<div class="modal fade" id="modal-upload-multiple">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">Add Picture Set</span></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="post" enctype="multipart/form-data">
                    <input style="display: none" id="endpoint-to-upload-multiple" type="text" value="">
                    <div class="d-flex flex-row align-items-center mb-2">
                        <i class="fas fa-images fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <input name="fileUpload" name="filePicture" id="picture-set-input" type = "file" multiple class="form-control"/>
                            <label class="fw-bold form-label" for="filePicture">Picture Set</label>
                            <div id="sp-upload-pic-set" style="display: none" class="spinner-border"></div>
                            <button type="button" onclick="uploadPictureSet(this)" class="w-100 py-2 mb-2 btn btn-dark mt-3">Add Picture Set</button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">

                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<!-- Modal update item -->
<div class="modal fade" id="modal-update-item">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">Update Items</span></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div class="row col-md-12 col-12">
                    <div class=" text-black">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-8 col-xl-8 order-2 order-lg-1">
                                    <div id="sp-load-item-update" style="display: none" class="spinner-border"></div>
                                    <form id="form-update-item" cssClass="mx-1 mx-md-4" method="post" enctype="multipart/form-data">
                                        <input style="display: none" id="area-itemID" type="text" value="">
                                        <div id="img-avatar-item-area" class="d-flex flex-row align-items-center mb-2">

                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="fileAvatar" id="item-update-avatar" type = "file" class="form-control"/>
                                                <label class="fw-bold form-label" for="item-update-avatar">Avatar</label>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-heading fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="name" id="item-update-name"type = "text" class="form-control"/>
                                                <div id="error-update-item-name"></div>
                                                <label class="fw-bold form-label" for="item-update-name">Name</label>

                                            </div>
                                        </div>
                                        <div class="row d-flex flex-row align-items-center mb-2">
                                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                                <i class="fas fa-box fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <input name="inventory" id="item-update-inventory" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');" step="1" min="0" type = "number" class="form-control"/>
                                                    <div id="error-update-item-inventory"></div>
                                                    <label class="fw-bold form-label" for="item-update-inventory">Inventory</label>

                                                </div>
                                            </div>
                                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                                <div class="form-outline flex-fill mb-0">
                                                    <input name="unitPrice" id="item-update-unitPrice"type = "number" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');" step="1" min="0" class="form-control"/>
                                                    <div id="error-update-item-unitPrice"></div>
                                                    <label class="fw-bold form-label" for="item-update-unitPrice">Unit Price</label>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-info fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input name="description" id="item-update-description" type = "text" class="form-control"/>
                                                <div id="error-update-item-description"></div>
                                                <label class="fw-bold form-label" for="item-update-description">Description</label>

                                            </div>
                                        </div>
                                        <div id="sp-update-item-1" style="display: none" class="spinner-border"></div>
                                        <button id="btn-update-item" type="button" onclick="updateItem(this)" class="w-100 py-2 mb-2 btn btn-dark">
                                            Update Item
                                        </button>
                                    </form>

                                </div>
                                <button style="display: none" id="btn-open-update-item" data-bs-toggle="modal" data-bs-target="#modal-update-item" ></button>
                                <div class="col-md-10 col-lg-4 col-xl-4 d-flex align-items-center order-1 order-lg-2">

                                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661238920/Usability_testing-pana_zyjjh5.png"
                                         class="img-fluid" alt="Sample image">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>