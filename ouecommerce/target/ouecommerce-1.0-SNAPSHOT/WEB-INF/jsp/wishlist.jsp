<%-- 
    Document   : wishlist
    Created on : 19 Aug 2022, 13:06:28
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="cart-wrap">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="main-heading mb-10"><h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1"><spring:message code="label.wishlist.title"/></span></h2> </div>
                <div class="table-wishlist">
                    <table cellpadding="0" cellspacing="0" border="0" width="100%">
                        <thead>
                            <tr>
                                <th width="45%"><spring:message code="label.wishlist.product.name"/></th>
                                <th width="15%"><spring:message code="label.wishlist.product.price"/></th>
                                <th width="15%"><spring:message code="label.wishlist.product.status"/></th>
                                <th width="15%"></th>
                                <th width="10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listPostInWishlist}" var="sp">
                            <tr id="salepost-in-wishlist-${sp.postID}">
                                <td width="45%">
                                    <div class="display-flex align-center">
                                        <div class="img-product">
                                            <img src="${sp.avatar}" alt="" class="mCS_img_loaded">
                                        </div>
                                        <div class="name-product">
                                            <a href="<c:url value="/product/product-details/${sp.postID}"/>" style="text-decoration: none" class="link-danger fw-bold">${sp.title}</a>
                                        </div>
                                    </div>
                                </td>
                                <td width="15%" class="price"> <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sp.finalPrice}"/> VND</td>
                                <td width="15%"><span class="in-stock-box">${sp.saleStatus.name}</span></td>
                                    <c:url value="/api/salepost/${sp.postID}/" var="endpoint"/>
                                    <c:url value="/api/list-items/${sp.postID}/" var="classifyapi"/>
                                    <c:url value="/" var="context"/>
                                <td width="15%"><button class="round-black-btn small-btn" data-bs-toggle="modal" onclick="loadClassify('${endpoint}', '${classifyapi}', '${context}')" data-bs-target="#myModalAddToCart"><spring:message code="label.index.adToCart"/></button></td>
                                <c:url value="/api/add-to-wishlist"  var="atw"/>
                                <td width="10%" class="text-center"><div style="display: none" id="sp-delete-${sp.postID}" class="spinner-border spinner-border-sm"></div><a onclick="removeFromWishlist('${atw}',${sp.postID},this)" href="#" class="trash-icon"><i class="far fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
