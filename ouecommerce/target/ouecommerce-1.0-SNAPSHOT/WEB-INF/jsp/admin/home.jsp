<%-- 
    Document   : admin
    Created on : 9 Aug 2022, 15:36:41
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col col-lg-12 col-xl-12">
    <div class="card">
        <div class="rounded-top text-white d-flex flex-row" style="background-color: #212529; height:300px;">
            <div class="ms-5 mt-5 d-flex flex-column" style="width: 150px;">
                <div style="width: 150px;height: 150px; z-index: 1">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1659378554/Artboard_1_copy_1_cbpaw9.png"
                         alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                         >
                </div>
            </div>
            <div class="ms-5" style="margin-top: 130px;">
                <h3 class="fw-bold">Admin Page </h3>
                <p>Management page of Ecommerce OU</p>
            </div>
        </div>
    </div>
</div>

<div class="container py-5">
    <p class="text-center h3 fw-bold mb-0 mx-1 mx-md-4 mt-2 text-uppercase">Overview On  Ecommerce OU</p>
</div>
<div class="col-12 col-md-12 row">
    <div class="col-8 col-md-8 main-content">
        <div class="d-flex my-4 flex-wrap">
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661924163/store_dqiefo.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">Total Agency</div>
                    <div class="ms-auto number">${countAgency}</div>
                </div>
            </div>
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661752432/gallery_x7mxl7.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">Post (active)</div>
                    <div class="ms-auto number">${countPost}</div>
                </div>
            </div>
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661924163/grocery_zdlgdj.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">Item(s)</div>
                    <div class="ms-auto number">${countItem}</div>
                </div>
            </div>
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661763545/man_ujvzfz.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">User(s)</div>
                    <div class="ms-auto number">${countUser}</div>
                </div>
            </div>
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661924163/categories_mprlqi.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">Categories</div>
                    <div class="ms-auto number">${listCategories.size()}</div>
                </div>
            </div>
            <div class="box me-4 my-1 bg-light">
                <img src="https://res.cloudinary.com/dec25/image/upload/v1661763749/trolley_m6emlm.png"
                     alt="">
                <div class="d-flex align-items-center mt-2">
                    <div class="tag">Order Placed</div>
                    <div class="ms-auto number">${countOrder}</div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4 col-4">
        <img src="https://res.cloudinary.com/dec25/image/upload/v1661238920/Usability_testing-pana_zyjjh5.png"
             class="img-fluid" alt="Sample image">

    </div>
</div>