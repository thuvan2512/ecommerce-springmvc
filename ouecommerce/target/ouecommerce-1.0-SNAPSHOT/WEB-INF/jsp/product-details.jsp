<%-- 
    Document   : product-details
    Created on : 11 Aug 2022, 09:35:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
    window.onload = function () {
        let cmtsDate = document.querySelectorAll(".cmt-date");
        if (cmtsDate != null) {
            for (i = 0; i < cmtsDate.length; i++) {
                let cont = cmtsDate[i].textContent;
                cmtsDate[i].innerText = moment(cont).fromNow();
            }
        }
    }
</script>
<div  style="margin-bottom: 50px;margin-top: 50px" class="container-fluid">
    <div class="row">
        <h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1"><spring:message code="label.productDetail.productDetail"/></span></h2>
        <div class="col-md-7 col-7 container-fluid">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="width: 80%;margin-left: 10%">
                <div class="carousel-inner">
                    <div style="height: 450px" class="carousel-item active">
                        <img class="img-fluid" src="${product.avatar}" class="d-block w-100" alt="avatar">
                    </div>
                    <c:forEach items="${product.picturePostSet}" var="picPost">
                        <div style="height: 450px" class="carousel-item ">
                            <img class="img-fluid" src="${picPost.image}" class="d-block w-100" alt="...">
                        </div>
                    </c:forEach>

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
                        <div id="star-rating-avg" class="product-rating">
                            <c:forEach begin="1" end="${star}">
                                <i class="rate fas fa-star"></i>
                            </c:forEach> 
                            <c:forEach begin="1" end="${haftStar}">
                                <i class="rate fas fa-star-half-alt"></i>
                            </c:forEach> 
                            <c:forEach begin="1" end="${nonStar}">
                                <i class="rate far fa-star"></i>
                            </c:forEach> 
                        </div>
                        <span class="fw-bold text-danger">&nbsp(<span id="rating-avg" ><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${starAvg}" /></span>)</span>
                    <a class="review-link" href="#comment-area"><span id="count-rating">${fn:length(listCommentPost)}</span> Review(s) &nbsp</a><a class="review-link" href="#comment-area"> &nbsp Add your review</a>
                </div>
                <div>
                    <h3 class="product-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.finalPrice}" /> VND 
                        <del class="product-old-price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.initialPrice}"/> VND</del></h3>
                    <span class="product-available">${product.saleStatus.name}</span>
                </div>
                <p>${product.description}</p>
                <div class="row">
                    <div class="col-md-6 col-6 product-options">
                        <h5><span class=" badge bg-dark text-uppercase fw-bold m-1"><spring:message code="label.productDetail.productInfo"/></span></h5>
                        <h6 class="fw-bold text-dark "><spring:message code="label.productDetail.category"/>: ${product.categoryID.name}</h6>
                        <h6 class="fw-bold text-dark "><spring:message code="label.productDetail.brand"/>: ${product.brand}</h6>
                        <h6 class="fw-bold text-dark "><spring:message code="label.productDetail.saleDate"/>: <fmt:formatDate pattern = "dd/MM/yyyy" 
                                        value = "${product.createdDate}" /></h6>
                        <h6 class="fw-bold text-dark ">Origin: ${product.origin}</h6>
                        <h6 class="fw-bold text-dark ">Manufacturer: ${product.manufacturer}</h6>
                        <!--                        <label for="qty">QTY:</label>
                                                <input type="number" id="qty" name="quantity" min="1" max="100">-->
                    </div>
                    <div class="col-md-6 col-6 product-options">
                        <h5><span class=" badge bg-dark text-uppercase fw-bold m-1"><spring:message code="label.productDetail.agencyInfo"/></span></h5>
                        <h6 class="fw-bold text-dark "> ${product.agencyID.name}</h6>
                        <h6 class="fw-bold text-dark"><spring:message code="label.productDetail.field"/>: ${product.agencyID.field.name}</h6>
                        <h6 class="fw-bold text-dark "><spring:message code="label.productDetail.hotline"/>: ${product.agencyID.hotline}</h6>
                        <h6 class="fw-bold text-dark "><spring:message code="label.productDetail.address"/>: ${product.agencyID.address}</h6>
                    </div>
                </div>
                <div class="add-to-cart d-flex justify-content-center">
                    <c:url value="/api/list-items/${product.postID}/" var="classifyapi"/>
                    <c:url value="/" var="context"/>
                    <c:url value="/api/salepost/${product.postID}/" var="endpoint"/>
                    <button onclick="loadClassify('${endpoint}', '${classifyapi}', '${context}')"  class="add-to-cart-btn" data-bs-toggle="modal" data-bs-target="#myModalAddToCart"><i class="fa fa-shopping-cart"></i> <spring:message code="label.index.adToCart"/></button>
                </div>
            </div>
        </div>
        <div class="col-md-12 col-12">

            <div class="container mt-5 mb-5">
                <div class="row height d-flex justify-content-center align-items-center">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="p-3" id="comment-area">
                                <h6 class="text-dark fw-bold"><spring:message code="label.productDetail.comments"/></h6>
                            </div>
                            <sec:authorize access="!isAuthenticated()">
                                <span class="alert alert-dark"><spring:message code="label.productDetail.comments.tip"/></span>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <div class="mt-3 d-flex flex-row align-items-center p-3 form-color">
                                    <img src="${currentUser.avatar}" width="50" class="rounded-circle mr-2"> &nbsp; &nbsp;
                                    <input id="cmtPost"width="50%" type="text" class="form-control" placeholder="<spring:message code="label.productDetail.comments.submit"/>">
                                </div>
                                <div class="star-comment-post">
                                    <div id="rating-post">
                                        <input type="radio" id="star55" name="rating-post" value="5" />
                                        <label for="star55" title="Awesome - 5 stars"></label>

                                        <input type="radio" id="star44" name="rating-post" value="4" />
                                        <label for="star44" title="Pretty good - 4 stars"></label>

                                        <input type="radio" id="star33" name="rating-post" value="3" />
                                        <label for="star33" title="Medium - 3 stars"></label>

                                        <input type="radio" id="star22" name="rating-post" value="2" />
                                        <label for="star22" title="Bad - 2 stars"></label>

                                        <input type="radio" id="star11" name="rating-post" value="1" />
                                        <label for="star11" title="Very Bad - 1 star"></label>
                                    </div>
                                </div>
                                <div class="p-3">
                                    <c:url value="/api/add-comment/${product.postID}" var="endpoint"></c:url>
                                    <c:url value="/api/get-average-star/${product.postID}" var="starAvg"></c:url>
                                    <button onclick="clearRate()" class="btn btn-dark"> <spring:message code="label.productDetail.comments.clearRate"/> </button>&nbsp;<button onclick="addCommentPost('${endpoint}', '${starAvg}')" class="btn btn-dark"> <spring:message code="label.productDetail.comments.comment"/></button>
                                </div>
                            </sec:authorize>
                            <div id= "cmt-area" class="mt-2">
                                <c:if test="${listCommentPost.size() == 0}">
                                    <h6 id="notify-null-cmt" class="text text-danger"> &nbsp;<spring:message code="label.productDetail.comments.empty"/></h6>
                                </c:if>
                                <c:forEach items="${listCommentPost}" var="cmt">
                                    <c:if test="${cmt.supComment == null}">
                                        <div class="d-flex flex-row p-3"> <img src="${cmt.userID.avatar}" width="40" height="40" class="rounded-circle mr-3">&nbsp;
                                            <div class="w-100">
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <div class="d-flex flex-row align-items-center"> <span class="mr-2 fw-bold">${cmt.userID.username}</span> &nbsp;<small class="c-badge">Top Comment</small> </div>
                                                </div>
                                                <p class="text-justify comment-text mb-0"><em>${cmt.content}</em></p>

                                                <div class="product-rating">
                                                    <c:if test="${cmt.starRate > 0}">
                                                        <c:forEach begin="1" end="${cmt.starRate}">
                                                            <i class="rate fas fa-star"></i> 
                                                        </c:forEach>
                                                        <c:forEach begin="1" end="${5 - cmt.starRate}">
                                                            <i class="rate far fa-star"></i>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>


                                                <div class="d-flex flex-row user-feed">
                                                    <small class="cmt-date">${cmt.createdDate}</small>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>