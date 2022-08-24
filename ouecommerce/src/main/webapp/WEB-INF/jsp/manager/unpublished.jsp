<%-- 
    Document   : unpublished
    Created on : 24 Aug 2022, 19:25:01
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row col-md-12 col-12">
    <div class="container py-5">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">Unpublished Sale Post</p>
        <c:if test="${listPostUnpublished.size() == 0}">
            <div style="margin-top: 50px;" class="col-12 col-md-12">
                <span class="badge bg-dark text-center"><h6>Empty product list <div class="spinner-border spinner-border-sm text-light"></div></h6></span>
            </div>
        </c:if>
        <c:forEach items="${listPostUnpublished}" var="post">
            <div id="unpublished-salepost-${post.postID}" class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <div class="card shadow-0 border rounded-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                        <div>
                                            <img src="${post.avatar}"
                                                 class="w-100 h-100" />
                                        </div>
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-uppercase fw-bold">${post.title}</h5>
                                    <h6 class="text text-danger fw-bold"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${post.finalPrice}"/> VND</h6>
                                    <h6>Created date: <span class="fw-bold"><fmt:formatDate pattern = "dd/MM/yyyy" value = "${post.createdDate}" /></span></h6>
                                    <h6>State: <span class="fw-bold">Unpublished</span></h6>
                                    <h6><span class="fw-bold">${post.itemSet.size()}</span> Item(s)</h6>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-column mt-2">
                                        <button class="btn btn-outline-dark btn-sm" type="button">Edit</button>
                                        <button data-bs-toggle="modal" data-bs-target="#modal-add-item" class="btn btn-outline-dark btn-sm mt-2" type="button">Add items</button>
                                        <button onclick="publishSalePost('<c:url value="/api/publish-salepost/${post.postID}"/>',${post.postID})" class="btn btn-outline-dark btn-sm mt-2" type="button">Publish</button>
                                        <button onclick="deleteSalePost('<c:url value="/api/delete-salepost/${post.postID}"/>',${post.postID})" class="btn btn-outline-dark btn-sm mt-2" type="button">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!--        <div class="row justify-content-center mb-3">
                    <div class="col-md-12 col-xl-10">
                        <div class="card shadow-0 border rounded-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                        <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/new/img(4).webp"
                                                 class="w-100" />
                                            <a href="#!">
                                                <div class="hover-overlay">
                                                    <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-6">
                                        <h5>Quant olap shirts</h5>
                                        <div class="d-flex flex-row">
                                            <div class="text-danger mb-1 me-2">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <span>289</span>
                                        </div>
                                        <div class="mt-1 mb-0 text-muted small">
                                            <span>100% cotton</span>
                                            <span class="text-primary"> • </span>
                                            <span>Light weight</span>
                                            <span class="text-primary"> • </span>
                                            <span>Best finish<br /></span>
                                        </div>
                                        <div class="mb-2 text-muted small">
                                            <span>Unique design</span>
                                            <span class="text-primary"> • </span>
                                            <span>For men</span>
                                            <span class="text-primary"> • </span>
                                            <span>Casual<br /></span>
                                        </div>
                                        <p class="text-truncate mb-4 mb-md-0">
                                            There are many variations of passages of Lorem Ipsum available, but the
                                            majority have suffered alteration in some form, by injected humour, or
                                            randomised words which don't look even slightly believable.
                                        </p>
                                    </div>
                                    <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                        <div class="d-flex flex-row align-items-center mb-1">
                                            <h4 class="mb-1 me-1">$14.99</h4>
                                            <span class="text-danger"><s>$21.99</s></span>
                                        </div>
                                        <h6 class="text-success">Free shipping</h6>
                                        <div class="d-flex flex-column mt-4">
                                            <button class="btn btn-primary btn-sm" type="button">Details</button>
                                            <button class="btn btn-outline-primary btn-sm mt-2" type="button">
                                                Add to wishlist
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
    </div>
</div>
