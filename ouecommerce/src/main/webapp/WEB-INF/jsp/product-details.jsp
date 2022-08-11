<%-- 
    Document   : product-details
    Created on : 11 Aug 2022, 09:35:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div  style="margin-bottom: 50px;margin-top: 50px" class="container-fluid">
    <div class="row">
        <h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1">Product Details</span></h2>
        <div class="col-md-7 col-7 container-fluid">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="width: 80%;margin-left: 10%">
                <div class="carousel-inner">
                    <div style="height: 450px" class="carousel-item active">
                        <img class="img-fluid" src="${product.avatar}" class="d-block w-100" alt="avatar">
                    </div>
                    <div style="height: 450px" class="carousel-item ">
                        <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658941724/products/red-white-b37635-ap-dung-ck_uuu96p.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div style="height: 450px" class="carousel-item ">
                        <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658942093/products/fea91b2da0c4cea3535a5bd35057cb7e_r2thz1.png" class="d-block w-100" alt="...">
                    </div>
                    <div style="height: 450px" class="carousel-item ">
                        <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658941724/products/red-white-b37635-ap-dung-ck_uuu96p.jpg" class="d-block w-100" alt="...">
                    </div>

                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class="col-md-5 col-5">
            <div class="product-details">
                <h3 class="product-name fw-bold text-dark text-uppercase">${product.title}</h3>
                <div>
                    <div class="product-rating">
                        <i class="rate fas fa-star"></i> 
                        <i class="rate fas fa-star"></i>
                        <i class="rate fas fa-star"></i>
                        <i class="rate fas fa-star-half-alt"></i>
                        <i class="rate far fa-star"></i>
                        <span class="fw-bold text-danger">&nbsp(3.5)</span>
                    </div>
                    <a class="review-link" href="#">10 Review(s) &nbsp</a><a class="review-link" href="#"> &nbsp Add your review</a>
                </div>
                <div>
                    <h3 class="product-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.finalPrice}" /> VND 
                        <del class="product-old-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.initialPrice}"/> VND</del></h3>
                    <span class="product-available">${product.saleStatus.name}</span>
                </div>
                <p>${product.description}</p>
                <div class="row">
                    <div class="col-md-6 col-6 product-options">
                        <h5><span class=" badge bg-dark text-uppercase fw-bold m-1">Product Info</span></h5>
                        <h6>Category: ${product.categoryID.name}</h6>
                        <h6>Brand: ${product.brand}</h6>
                        <h6>Sale date: <fmt:formatDate pattern = "dd/MM/yyyy" 
                                                    value = "${product.createdDate}" /></h6>
                        <h6>Origin: ${product.origin}</h6>
                        <h6>Manufacturer: ${product.manufacturer}</h6>
<!--                        <label for="qty">QTY:</label>
                        <input type="number" id="qty" name="quantity" min="1" max="100">-->
                    </div>
                    <div class="col-md-6 col-6 product-options">
                        <h5><span class=" badge bg-dark text-uppercase fw-bold m-1">Agency Info</span></h5>
                        <h6 class="fw-bold text-danger "> ${product.agencyID.name}</h6>
                        <h6 >Field: ${product.agencyID.field.name}</h6>
                        <h6 >Hotline: ${product.agencyID.hotline}</h6>
                        <h6 >Address: ${product.agencyID.address}</h6>
                    </div>
                </div>
                <div class="add-to-cart d-flex justify-content-center">
                    <button class="add-to-cart-btn" data-bs-toggle="modal" data-bs-target="#myModalAddToCart"><i class="fa fa-shopping-cart"></i> add to cart</button>
                </div>
            </div>
        </div>
    </div>
</div>