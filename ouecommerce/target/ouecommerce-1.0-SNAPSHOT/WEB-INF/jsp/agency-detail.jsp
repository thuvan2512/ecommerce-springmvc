<%-- 
    Document   : agency
    Created on : 1 Sep 2022, 21:06:36
    Author     : thu.nv2512
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid row">
    <div class="col col-lg-12 col-xl-12">
        <div class="card">
            <div class="rounded-top text-white d-flex flex-row" style="background-color: #dfe6e9; height:300px;">
                <div class="ms-5 mt-5 d-flex flex-column" style="width: 150px;">
                    <div style="width: 150px;height: 150px; z-index: 1">
                        <img src="${agency.avatar}"
                             alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                             >
                    </div>
                </div>
                <div class="ms-5" style="margin-top: 130px;">
                    <h3 class="fw-bold text-dark">${agency.name} </h3>
                    <p class="fw-bold text-dark">${agency.field.name}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="col-12 col-md-12 row">
        <div class="col-6 col-md-6 main-content row">
            <div class="container py-5">
                <p class="text-center h3 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">General</p>
            </div>
            <div class="d-flex my-4 flex-wrap">
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763545/gallery_pz27ed.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Sale Post</div>
                        <div class="ms-auto number">${countProducts}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763749/trolley_m6emlm.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Orders placed</div>
                        <div class="ms-auto number">${listOrderDetail.size()}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661752602/online-shopping_wqanzo.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Quantity Sold</div>
                        <div class="ms-auto number">${countSold}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661752526/1244038_xgdn2l.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Like(s)</div>
                        <div class="ms-auto number">${countLike}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763545/comment_puc6r3.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Comment(s)</div>
                        <div class="ms-auto number">${countComment}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661767185/police-badge_f35ei8.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Average star</div>
                        <div class="ms-auto number"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${avgStar}" /></div>
                    </div>
                </div>
            </div>
            <div class="mb-2 col-md-12 col-12">
                <p class="lead fw-normal mb-1">About</p>
                <div class="p-4" >
                    <p class="font-italic mb-1">Manager: <span class="fw-bold">${agency.manager.username}</span></p>
                    <c:if test="${agency.isActive == 0}"><p class="font-italic mb-1">State:<span class="fw-bold"> Banned from operation</span></p></c:if>
                    <c:if test="${agency.isActive == 1}"><p class="font-italic mb-1">State:<span class="fw-bold"> Active</span></p></c:if>
                    <p class="font-italic mb-1">Agent Field: ${agency.field.name}</p>
                    <p class="font-italic mb-1">Created Date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${agency.createdDate}"/></p>
                    <p class="font-italic mb-1">Hotline: ${agency.hotline}</p>
                    <p class="font-italic mb-1">Address:  ${agency.address}</p>
                </div>

            </div>
        </div>
        <div class="col-md-6 col-6">
            <img src="https://res.cloudinary.com/dec25/image/upload/v1661752976/In_no_time-rafiki_fj70mm.png"
                 class="img-fluid" alt="Sample image">
        </div>
    </div>
    <div class="col-12 col-md-12">
        <div class="container py-5">
            <p class="text-center h3 fw-bold mb-2 mx-1 mx-md-4 mt-0 text-uppercase">Sale Post</p>
        </div>
        <div class="cart-wrap">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wishlist">
                            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                <thead>
                                    <tr>
                                        <th width="45%">Product Name</th>
                                        <th width="15%">Price</th>
                                        <th idth="10%">Unofficial price</th>
                                        <th width="15%">Status</th>
                                        <th width="15%"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listPostAgency}" var="sp">
                                        <tr id="salepost-in-wishlist-${sp.postID}">
                                            <td width="45%">
                                                <div class="display-flex align-center">
                                                    <div class="img-product">
                                                        <img src="${sp.avatar}" alt="" class="mCS_img_loaded">
                                                    </div>
                                                    <div class="name-product">
                                                        <a href="<c:url value="/product/product-details/${sp.postID}"/>" class="link-danger fw-bold" style="text-decoration: none">${sp.title}</a>
                                                    </div>
                                                </div>
                                            </td>
                                            <td width="15%" class="price"> <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sp.finalPrice}"/> VND</td>
                                            <td width="15%" class="price"> <del><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sp.initialPrice}"/> VND</del></td>
                                            <td width="15%"><span class="in-stock-box">${sp.saleStatus.name}</span></td>
                                                <c:url value="/api/salepost/${sp.postID}/" var="endpoint"/>
                                                <c:url value="/api/list-items/${sp.postID}/" var="classifyapi"/>
                                                <c:url value="/" var="context"/>
                                            <td width="15%"><button class="round-black-btn small-btn" data-bs-toggle="modal" onclick="loadClassify('${endpoint}', '${classifyapi}', '${context}')" data-bs-target="#myModalAddToCart">Add to Cart</button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
