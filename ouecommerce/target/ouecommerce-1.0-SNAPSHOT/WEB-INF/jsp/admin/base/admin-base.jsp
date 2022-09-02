<%-- 
    Document   : admin-base
    Created on : 30 Aug 2022, 10:56:21
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="<c:url value="/admin/home"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-eye"></i>&nbsp;
                        Overview
                    </a>
                </li>  
                <li>
                    <a href="<c:url value="/admin/notifications"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-bell"></i>&nbsp;
                        Notifications
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/admin/orders"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-box"></i>&nbsp;
                        Orders
                    </a>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse2" aria-expanded="false">
                        <i class="fas fa-store"></i>&nbsp;
                        Agency &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse2" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="<c:url value="/admin/censorship"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Censorship Agency</a></li>
                            <li><a href="<c:url value="/admin/agency"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Agency Management</a></li>
                            <li><a href="<c:url value="/admin/banned-agency"/>" class="nav-link link-danger text-uppercase fw-bold d-inline-flex text-decoration-none ">Banned Agency</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="<c:url value="/admin/general-stats"/>" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-chart-area"></i>&nbsp;
                        Statistics
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
        <tiles:insertAttribute name="adminContent"/>                      
    </div>

</div>


<!-- The Modal -->
<div class="modal fade" id="modal-view-details-agency">
    <div class="modal-dialog modal-md">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">View Detail Agency</span></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div style="display: none" id="sp-load-quickview-agency" class="spinner-border"></div>
                <div id="view-detail-agency-area" class="card" style="width:100%">

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
</div>