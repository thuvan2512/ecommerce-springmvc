<%-- 
    Document   : orders
    Created on : 24 Aug 2022, 02:18:05
    Author     : thu.nv2512
order manager
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row col-md-12 col-12">
    <div class="container py-3">
        <p class="text-center h1 fw-bold mb-0 mx-1 mx-md-4 mt-4 text-uppercase">Orders</p>
    </div>
    <div class=" row col-12 col-md-12">
        <div class="col-9 col-md-9 main-content">
            <div class="d-flex my-4 flex-wrap">
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661668526/cardboard-box-brown-vector-graphic-pixabay-2_z3dqeu.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Orders placed</div>
                        <div class="ms-auto number">${listOrderDetail.size()}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661762937/confirm_tjmdsy.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Confirmed</div>
                        <div class="ms-auto number">0</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-3 col-md-3">

            <img src="https://res.cloudinary.com/dec25/image/upload/v1661752976/In_no_time-bro_xbvwyv.png"
                 class="img-fluid" alt="Sample image">

        </div>
    </div>
    <div class="col-12 col-md-12">
        <c:forEach items="${listOrderDetail}" var="listOD">
            <article style="background-color:#f8f9fa" class="card mb-5">
                <div class="card-body">
                    <h6>Order ID: #${listOD.value[0].orderID.orderID}</h6>
                    <article class="card">
                        <div class="card-body row">
                            <div class="col-md-2">
                                <strong>Confirm</strong> 

                                <div style="margin-top: 20px" onclick="toggleButtonClick(this)" class="toggle-btn">
                                    <div class="inner-circle"></div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <strong>Created date</strong><br> <br><fmt:formatDate pattern = "dd/MM/yyyy" value = "${listOD.value[0].orderID.createdDate}" />
                            </div>
                            <div class="col-md-2"> 
                                <strong>Payment type</strong><br> <br> ${listOD.value[0].orderID.paymentType.name}
                            </div>
                            <c:if test="${listOD.value[0].orderID.paymentState == 1}">
                                <div class="col-md-2"> <strong>Payment state</strong><br> <br>Paid</div>
                                </c:if>
                                <c:if test="${listOD.value[0].orderID.paymentState == 0}">
                                <div class="col-md-2"> <strong>Payment state</strong><br> <br>Unpaid</div>
                                </c:if>
                            <div class="col-4"> <strong>Ship to</strong><br> ${listOD.value[0].orderID.userID.username}<br>Address: ${listOD.value[0].orderID.userID.address}</div>
                        </div>
                    </article>

                    <c:forEach items="${listOD.value}" var="od">
                        <div class="row justify-content-center mb-2 mt-2">
                            <div class="col-md-12 col-xl-10">
                                <div class="card shadow-0 border rounded-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                    <img src="${od.itemID.avatar}"
                                                         class="w-50 h-50" />
                                                    <a href="#!">
                                                        <div class="hover-overlay">
                                                            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-5 col-xl-5">
                                                <h6 class="fw-bold text-dark">${od.itemID.name}</h6>
                                                <h6 class="fw-bold text-danger"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${od.itemID.unitPrice}"/> VND</h6>
                                                <h6 class="fw-bold text-dark">Qty: ${od.quantity} & ${od.itemID.description}</h6>
                                            </div>
                                            <div class="col-md-6 col-lg-4 col-xl-4 border-sm-start-none border-start">
                                                <h6 class="text-dark fw-bold">Temporary Price</h6>
                                                <div class="d-flex flex-row align-items-center mb-1">
                                                    <h6 class="mb-1 me-1 fw-bold text-danger"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${od.itemID.unitPrice * od.quantity}"/> VND</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </article>
                        <hr style="height: 3px;color: black">
        </c:forEach>
    </div>
</div>
