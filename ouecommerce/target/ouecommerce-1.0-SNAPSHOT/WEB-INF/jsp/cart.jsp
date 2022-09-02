<%-- 
    Document   : cart
    Created on : 14 Aug 2022, 08:21:43
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div style="margin-bottom: 30px;margin-top: 50px;"class="container">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-md-9">
                <div class="ibox">
                    <div class="ibox-title">
                        <span class="pull-right">(<strong id="cart-count-items">${carts.size()}</strong>) items</span>
                        <h5> <spring:message code="label.cart.itemArea"/></h5>
                    </div>
                    <c:forEach items="${carts}" var="c">
                        <c:url value="/api/getTotalQty" var="getNewQty"/>
                        <c:url value="/api/getTotalPrice" var="getNewTotal"/>
                        <div id="cart${c.itemID}" class="ibox-content">
                            <div class="table-responsive">
                                <table class="table shoping-cart-table">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <div style="width: 90px;height: 90px" class="cart-product-imitation">
                                                    <img class="img-fluid" src="${c.picture}" alt="alt"/>
                                                </div>
                                            </td>
                                            <td class="desc">
                                                <h5>
                                                    <a href="#" class="text-navy">
                                                        ${c.name}
                                                    </a>
                                                </h5>
                                                <p class="small">
                                                    ${c.description}
                                                </p>
                                                <div class="m-t-sm">
                                                    <c:url value="/api/delete-cart/${c.itemID}/" var="apiDelete"/>
                                                    <c:url value="/api/count-items" var="countItems"/>
                                                    <div style="display: none" id="sp-delcart-${c.itemID}" class="spinner-border spinner-border-sm"></div>
                                                    <a id="btn-delcart-${c.itemID}" onclick="deleteCart('${apiDelete}', '${c.itemID}', '${getNewQty}', '${getNewTotal}', '${countItems}')" href="#" class="text-muted"><i class="fa fa-trash"></i> <spring:message code="label.cart.delete"/></a>
                                                </div>
                                            </td>

                                            <td>
                                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.unitPrice}"/> VND
                                            </td>
                                            <td width="80">
                                                <c:url value="/api/update-cart/${c.itemID}/" var="apiUpdate"/>
                                                <c:url value="/api/getTotalItem/${c.itemID}/" var="apiTotalItem"/>
                                                <c:url value="/api/count-items-quantity/${c.itemID}/" var="apiItemQty"/>
                                                <input onblur="updateCart(this, '${apiUpdate}','${getNewQty}', '${getNewTotal}','${apiTotalItem}','${apiItemQty}',${c.itemID})" type="number" min="1" value="${c.quantity}" class="form-control"/>
                                            </td>
                                            <td style="width: 150px!important">
                                                <h6 class="fw-bold text-danger" id="total-item-${c.itemID}">
                                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.total}"/> VND
                                                </h6>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </c:forEach>

                    <div class="ibox-content">
                        <c:url value="/payment" var="pay"/>
                        <a href="${pay}" style="color: white" class="btn btn-danger pull-right"><i class="fa fa fa-shopping-cart"></i> <spring:message code="label.cart.checkout"/></a>
                        <button class="btn btn-white"><a href="<c:url value="/"/>"><i class="fa fa-arrow-left"></i><spring:message code="label.cart.continueShopping"/></a></button>

                    </div>
                </div>

            </div>
            <div class="col-md-3">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5><spring:message code="label.cart.summary"/></h5>
                    </div>
                    <div class="ibox-content">
                        <span>
                            <spring:message code="label.cart.total"/>
                        </span>
                        <div style="display: none" id="sp-cart-total-price" class="spinner-border spinner-border-sm"></div>
                        <h2 class="font-bold" id="cart-total">
                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPrice}"/> VND
                        </h2>

                        <hr>
                        <span class="text-muted small">
                            <spring:message code="label.cart.tip"/>
                        </span>
                        <div style="margin-top: 10px" class="m-t-sm">
                            <div class="btn-group">
                                <a href="${pay}" style="color: white"  class="btn btn-danger"><i class="fa fa-shopping-cart"></i> <spring:message code="label.cart.checkout"/></a>
                                &nbsp;
                                <button class="btn btn-danger"> <spring:message code="label.cart.cancel"/></button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="ibox">
                    <div class="ibox-title">
                        <h5><spring:message code="label.cart.support"/></h5>
                    </div>
                    <div class="ibox-content text-center">
                        <h3><i class="fa fa-phone"></i> (+084) 784301745</h3>
                        <span class="small">
                            <spring:message code="label.cart.support.tip"/>
                        </span>
                    </div>
                </div>
                <div class="ibox-content">

                    <div class="ibox-title">
                        <h5>Top Seller</h5>
                    </div>
                    <hr>
                    <c:forEach items="${topSeller}" var="pt">
                        <div style="margin-bottom: 10px;">
                            <c:url value="/product/product-details/${pt[1].postID}" var="pDetails"/>
                            <a href="${pDetails}" class="product-name"><h5>${pt[2]} - ${pt[5]}</h5></a>
                            <div class="small m-t-xs">
                                <h6 class="text-danger fw-bold"> <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${pt[3]}"/> VND</h6>
                                <h6>Sold: ${pt[4]}</h6>
                            </div>
                            <div class="m-t text-righ">
                                <c:url value="/api/salepost/${pt[1].postID}/" var="endpoint"/>
                                <button onclick="quickView('${endpoint}')" class="btn  btn-danger" class="quick-view" data-bs-toggle="modal" data-bs-target="#myModal">Info &nbsp;<i class="fas fa-arrow-right"></i></button>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
