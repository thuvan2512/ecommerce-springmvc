<%-- 
    Document   : product-details
    Created on : 11 Aug 2022, 09:35:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
        <h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1">Product Details</span></h2>
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
                    <c:if test="${fn:length(product.commentPostSet) > 0}">
                        <div class="product-rating">
                            <c:forEach begin="1" end="${star}">
                                <i class="rate fas fa-star"></i>
                            </c:forEach> 
                            <c:forEach begin="1" end="${haftStar}">
                                <i class="rate fas fa-star-half-alt"></i>
                            </c:forEach> 
                            <c:forEach begin="1" end="${nonStar}">
                                <i class="rate far fa-star"></i>
                            </c:forEach> 
                            <span class="fw-bold text-danger">&nbsp(<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${starAvg}" />)</span>
                        </div>
                    </c:if>
                    <a class="review-link" href="#comment-area">${fn:length(product.commentPostSet)} Review(s) &nbsp</a><a class="review-link" href="#comment-area"> &nbsp Add your review</a>
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
                    <c:url value="/api/list-items/${product.postID}/" var="classifyapi"/>
                    <c:url value="/" var="context"/>
                    <c:url value="/api/salepost/${product.postID}/" var="endpoint"/>
                    <button onclick="loadClassify('${endpoint}', '${classifyapi}','${context}')"  class="add-to-cart-btn" data-bs-toggle="modal" data-bs-target="#myModalAddToCart"><i class="fa fa-shopping-cart"></i> add to cart</button>
                </div>
            </div>
        </div>
        <div class="col-md-12 col-12">

            <div class="container mt-5 mb-5">
                <div class="row height d-flex justify-content-center align-items-center">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="p-3" id="comment-area">
                                <h6>Comments</h6>
                            </div>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <div class="mt-3 d-flex flex-row align-items-center p-3 form-color">
                                    <img src="${currentUser.avatar}" width="50" class="rounded-circle mr-2"> &nbsp; &nbsp;
                                    <input id="cmtPost"width="50%" type="text" class="form-control" placeholder="Enter your comment...">
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
                                    <button onclick="clearRate()" class="btn btn-dark"> Clear your rate</button>&nbsp;<button onclick="addCommentPost('${endpoint}')" class="btn btn-dark"> Comment</button>
                                </div>
                            </c:if>
                            <div id= "cmt-area" class="mt-2">
                                <c:if test="${product.commentPostSet.size() == 0}">
                                    <h6 class="text text-danger"> &nbsp;There are no reviews yet</h6>
                                </c:if>
                                <c:forEach items="${product.commentPostSet}" var="cmt">
                                    <c:if test="${cmt.supComment == null}">
                                        <div class="d-flex flex-row p-3"> <img src="${cmt.userID.avatar}" width="40" height="40" class="rounded-circle mr-3">&nbsp;
                                            <div class="w-100">
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <div class="d-flex flex-row align-items-center"> <span class="mr-2 fw-bold">${cmt.userID.username}</span> &nbsp;<small class="c-badge">Top Comment</small> </div> <small class="cmt-date">${cmt.createdDate}</small>
                                                </div>
                                                <p class="text-justify comment-text mb-0">${cmt.content}</p>
                                                <c:if test="${cmt.starRate > 0}">
                                                    <div class="product-rating">
                                                        <c:forEach begin="1" end="${cmt.starRate}">
                                                            <i class="rate fas fa-star"></i> 
                                                        </c:forEach>
                                                        <c:forEach begin="1" end="${5 - cmt.starRate}">
                                                            <i class="rate far fa-star"></i>
                                                        </c:forEach>
                                                    </div>
                                                </c:if>

                                                <div class="d-flex flex-row user-feed"> <span class="wish"><a href="#"><i class="fas fa-comment-dots"></i> ${fn:length(cmt.commentPostSet)}</a></span>&nbsp;&nbsp;<span class="wish">
                                                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                                                            <a href="#"><i class="fas fa-reply"></i> Reply</a>
                                                        </c:if>
                                                    </span> </div>
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