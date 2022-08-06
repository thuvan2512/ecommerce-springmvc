<%-- 
    Document   : header
    Created on : 3 Aug 2022, 15:35:48
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="endpoint"/>
<nav id="navbar" class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">
            <img src="<c:url value="/images/logo/logo.png"/>" alt="Avatar Logo" style="width:40px;" class="rounded-pill"> 
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${endpoint}"><i class="fas fa-home"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#categories"><i class="fas fa-list-ul"></i> Categories</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-box-open"></i> Gallery</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"><i class="fas fa-store"></i> Follow</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-heart"></i> Wishlist</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-users"></i> About Us</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-envelope-open-text"></i> Introduce</a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-balance-scale"></i> Policy & Terms</a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-phone-alt"></i> Contact</a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-comment"></i> Feedback</a></li>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-headset"></i> Help & Support</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-user-alt"></i> Your Account</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"><i class="fas fa-id-badge"></i> View Profile</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-user-plus"></i> Sign Up</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-sign-in-alt"></i> Sign In</a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i> Sign Out</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">
                        <i class="fas fa-shopping-cart"></i>
                        <span> Cart </span> 
                        <span class="badge bg-danger">0</span>
                    </a>
                </li>
            </ul>
            <div id ="search"  style="display: none">
                <form action="<c:url value="/search"/>" class="d-flex">
                    <select name="category" class="form-select me-1">
                        <option value="all">All Categories</option>
                        <c:forEach items="${listCategories}" var="cate">
                            <option value="${cate.categoryID}">${cate.name}</option>
                        </c:forEach>
                    </select>
                    <input name="kw" class="form-control me-2" type="text" placeholder="Search for products">
                    <input type="submit"  class="btn btn-danger" value="Search"/>
                </form>
                </di>
            </div>
        </div>
</nav>
<!-- function-bar  -->  
<div  class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
    <div class="col-lg-4">
        <a href="" class="text-decoration-none">
            <span class="h1 text-uppercase fw-bold text-danger bg-dark px-2">OU</span>
            <span class="h1 text-dark fw-bold text-uppercase bg-danger px-2 ml-n1">E-Commerce</span>
        </a>
    </div>
    <div class="col-lg-6 col-sm-8 col-9 text-left">
        <form action="<c:url value="/search"/>">
            <div class="input-group">
                <div class="col-md-3">
                    <select name="category" id="cate" class="form-select">
                        <option value="all">All Categories</option>
                        <c:forEach items="${listCategories}" var="cate">
                            <option value="${cate.categoryID}">${cate.name}</option>
                        </c:forEach>

                    </select>
                </div>
                <input type="text" name="kw" class="form-control" placeholder="Search for products">
                <div class="input-group-append">
                    <span class="input-group bg-transparent text-danger">
                        <input class="btn btn-danger" type="submit" value="Search"/>
                    </span>
                </div>
            </div>
        </form>
    </div>
    <div class="col-lg-2 col-3 col-sm-4 text-right">
        <select class="form-select">
            <option value="1" selected>
                English (ENG)
            </option>
            <option value="2">
                Vietnamese (VIE)
            </option>
        </select>
    </div>
</div>
<!-- function-bar  -->  