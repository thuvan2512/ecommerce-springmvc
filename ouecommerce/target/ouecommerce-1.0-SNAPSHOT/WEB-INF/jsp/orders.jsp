<%-- 
    Document   : orders
    Created on : 28 Aug 2022, 12:32:26
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin-bottom: 100px;margin-top: 50px" class="container mt-4">
    <div class="row">
        <div class="col-lg-12 my-lg-0 my-1">
            <div  class="main-content bg-white border">
                <div class="d-flex my-4 flex-wrap">
                    <div class="box me-4 my-1 bg-light">
                        <img src="https://res.cloudinary.com/dec25/image/upload/v1661668526/cardboard-box-brown-vector-graphic-pixabay-2_z3dqeu.png"
                             alt="">
                        <div class="d-flex align-items-center mt-2">
                            <div class="tag">Orders placed</div>
                            <div class="ms-auto number">${listOrders.size()}</div>
                        </div>
                    </div>
                    <div class="box me-4 my-1 bg-light">
                        <img src="https://res.cloudinary.com/dec25/image/upload/v1661668526/shopping-cart-campus-recreation-university-nebraska-lincoln-30_fahf3r.png"
                             alt="">
                        <div class="d-flex align-items-center mt-2">
                            <div class="tag">Items in Cart</div>
                            <div class="ms-auto number">${countCart}</div>
                        </div>
                    </div>
                    <div class="box me-4 my-1 bg-light">
                        <img src="https://res.cloudinary.com/dec25/image/upload/v1661668526/love-png-heart-symbol-wikipedia-11_udnm3n.png"
                             alt="">
                        <div class="d-flex align-items-center mt-2">
                            <div class="tag">Wishlist</div>
                            <div class="ms-auto number">${wishlist.size()}</div>
                        </div>
                    </div>
                </div>
                <div class="text-uppercase">My recent orders</div>
                <c:forEach items="${listOrders}" var="order">
                    <div class="order my-3 bg-light">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="d-flex flex-column justify-content-between order-summary">
                                    <div class="d-flex align-items-center">
                                        <div class="text-uppercase">Order #${order.orderID}</div>
                                    </div><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${order.totalPrice}" var="totalPrice"/>
                                    
                                        <div class="fs-13 text-danger fw-bold">${totalPrice} VND</div>
                                    <c:if test="${order.paymentState == 0}">
                                        <div class="fs-8">Payment State: <span class="fw-bold">Unpaid</span></div>
                                    </c:if>
                                    <div class="fs-8"><span class="fw-bold">${order.orderDetailsSet.size()}</span> item(s) in this order</div>
                                    <c:if test="${order.paymentState == 1}">
                                        <div class="fs-8">Payment State: <span class="fw-bold">Paid</span></div>
                                    </c:if>
                                    <div class="fs-8">Created date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${order.createdDate}" /></div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="d-sm-flex align-items-sm-start justify-content-sm-between">
                                    <div class="status">Status : ${order.orderState.name}</div>
                                    <button onclick="viewDetailOrder('<c:url value="/api/list-order-detail/${order.orderID}"/>','${totalPrice}')" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#modal-detail-order">Detail</button>
                                </div>
                                <div class="progressbar-track">
                                    <ul class="progressbar">
                                        <li id="step-1" class="text-dark green">
                                            <span class="fas fa-gift"></span>
                                        </li>
                                        <c:if test="${order.orderState.osID < 2}">
                                            <li id="step-2" class="text-dark">
                                                <span class="fas fa-check"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID >= 2}">
                                            <li id="step-2" class="text-dark green">
                                                <span class="fas fa-check"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID < 3}">
                                            <li id="step-3" class="text-dark">
                                                <span class="fas fa-box"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID >= 3}">
                                            <li id="step-3" class="text-dark green">
                                                <span class="fas fa-box"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID < 4}">
                                            <li id="step-4" class="text-dark">
                                                <span class="fas fa-truck"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID >= 4}">
                                            <li id="step-4" class="text-dark green">
                                                <span class="fas fa-truck"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID < 5}">
                                            <li id="step-5" class="text-dark">
                                                <span class="fas fa-box-open"></span>
                                            </li>
                                        </c:if>
                                        <c:if test="${order.orderState.osID == 5}">
                                            <li id="step-5" class="text-dark green">
                                                <span class="fas fa-box-open"></span>
                                            </li>
                                        </c:if>


                                    </ul>
                                    <div id="tracker"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
