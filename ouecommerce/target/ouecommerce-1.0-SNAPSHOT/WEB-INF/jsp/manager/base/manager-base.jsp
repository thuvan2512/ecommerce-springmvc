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
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse2" aria-expanded="false">
                        <i class="fas fa-th"></i>&nbsp;
                        Products &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse2" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="<c:url value="/manager/add-product"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">New Products</a></li>
                            <li><a href="<c:url value="/manager/unpublished-products"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Unpublished Products</a></li>
                            <li><a href="<c:url value="/manager/products"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Products Management</a></li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse-order" aria-expanded="false">
                        <i class="fas fa-box"></i>&nbsp;
                        Orders &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse-order" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="<c:url value="/manager/unconfirmed-orders"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Unconfirmed orders</a></li>
                            <li><a href="<c:url value="/manager/orders"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Order Status</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="<c:url value="/manager/revenue-stats"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-chart-area"></i>&nbsp;
                        Revenue statistics
                    </a>
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
                                    <form cssClass="mx-1 mx-md-4" method="post" enctype="multipart/form-data">
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-heading fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input id="salepost-title"type = "text" class="form-control"/>
                                                <label class="fw-bold form-label" for="salepost-title">Title</label>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-2">
                                            <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input id="salepost-avatar" type = "file" class="form-control"/>
                                                <label class="fw-bold form-label" for="salepost-avatar">Avatar</label>
                                            </div>
                                        </div>
                                        <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                                            Add Item
                                        </button>
                                    </form:form>
                                </div>
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