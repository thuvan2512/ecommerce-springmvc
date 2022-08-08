<%-- 
    Document   : header
    Created on : 3 Aug 2022, 15:35:48
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <a class="nav-link" href="${endpoint}"><i class="fas fa-home"></i> <spring:message code="label.nav.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#categories"><i class="fas fa-list-ul"></i> <spring:message code="label.nav.categories"/></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-box-open"></i> <spring:message code="label.nav.gallery"/> </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#"><i class="fas fa-store"></i> <spring:message code="label.nav.follow"/></a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-heart"></i> <spring:message code="label.nav.wishList"/></a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-users"></i> <spring:message code="label.nav.aboutUs"/></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-envelope-open-text"></i> <spring:message code="label.nav.intro"/></a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-balance-scale"></i> <spring:message code="label.nav.pnT"/></a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-phone-alt"></i> <spring:message code="label.nav.contact"/></a>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-comment"></i> <spring:message code="label.nav.feedback"/></a></li>
                        <li><a class="dropdown-item" href="#about-us"><i class="fas fa-headset"></i> <spring:message code="label.nav.hnS"/></a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-user-alt"></i> <spring:message code="label.nav.account"/></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value="/user/sign-up"/>"><i class="fas fa-user-plus"></i> <spring:message code="label.nav.signUp"/></a></li>
                        <li><a class="dropdown-item" href="#"><i class="fas fa-sign-in-alt"></i> <spring:message code="label.nav.signIn"/></a></li>                    
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">
                        <i class="fas fa-shopping-cart"></i>
                        <span> <spring:message code="label.nav.cart"/> </span> 
                        <span class="badge bg-danger">0</span>
                    </a>
                </li>
                <li class="nav-item">
                    <div class="flex-shrink-0 dropdown">
                        <a href="#" class="d-block link-dark text-decoration-none" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://res.cloudinary.com/dec25/image/upload/v1655434671/u4uid1cmt7sn7gbxoeu7.jpg" alt="mdo" width="40" height="40" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2" style="">
                            <li><p class="fw-bold text-center">thunv.admin</p></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#"><i class="fas fa-id-badge"></i> <spring:message code="label.nav.viewProfile"/></a></li>
<!--                            <li><a class="dropdown-item" href="#"><i class="fas fa-user-plus"></i> <spring:message code="label.nav.signUp"/></a></li>
                            <li><a class="dropdown-item" href="#"><i class="fas fa-sign-in-alt"></i> <spring:message code="label.nav.signIn"/></a></li>-->
                            <li><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i> <spring:message code="label.nav.signOut"/></a></li>
                        </ul>
                    </div>
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
        <div class="dropdown">
            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                Language
            </button>
            <c:url value="/" var="endp"/>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li class><a class="dropdown-item" href="${endp}?lang=en">English (ENG)</a></li>
                <li><a class="dropdown-item" href="${endp}?lang=vi">Vietnamese (VIE)</a></li>
            </ul>
        </div>
    </div>
</div>

<!-- function-bar  -->  