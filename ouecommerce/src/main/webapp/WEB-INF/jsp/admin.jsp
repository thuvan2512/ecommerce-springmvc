<%-- 
    Document   : admin
    Created on : 9 Aug 2022, 15:36:41
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="row">
    <div class="col-md-3 col-3">
        <div style="position: fixed;height: 100%;width: 20%;"class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
            <a href="<c:url value="/admin/home"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
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
                    <li><a class="dropdown-item" href="#">New project...</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Sign out</a></li>
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
                <li class="mb-1">
                    <button class="btn btn-toggle nav-link text-white text-uppercase fw-bold" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
                        <i class="fas fa-store"></i>&nbsp;
                        Agency &nbsp;&Xi;
                    </button>
                    <div class="collapse" id="dashboard-collapse" style="">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="#" class="nav-link link-light text-uppercase fw-bold d-inline-flex text-decoration-none ">Overview</a></li>
                            <li><a href="#" class="nav-link link-light text-uppercase fw-bold d-inline-flex text-decoration-none ">Weekly</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-th-large"></i>&nbsp;
                        Products
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link text-white text-uppercase fw-bold">
                        <i class="fas fa-users"></i>&nbsp;
                        Users
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link text-white text-uppercase fw-bold">
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
    <div class="col-md-7">
        <div class="container px-4 py-5">
            <h2 class="pb-2 border-bottom">Columns with icons</h2>
            <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                <div class="feature col">
                    <h2>Featured title</h2>
                    <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                    <a href="#" class="icon-link d-inline-flex align-items-center">
                        Call to action
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"></use></svg>
                    </a>
                </div>
            </div>
        </div>
    </div>

</div>