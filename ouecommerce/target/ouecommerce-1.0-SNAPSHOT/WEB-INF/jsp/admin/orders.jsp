<%-- 
    Document   : orders
    Created on : 30 Aug 2022, 11:19:41
    Author     : thu.nv2512
order admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin-bottom: 100px;margin-top: 50px" class="container mt-4">
    <div class="row">
        <div class="container py-5">
            <p class="text-center h1 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">List Order</p>
        </div>
        <div class="col-lg-12 my-lg-0 my-1">
            <div  class="bg-white border">
                <c:forEach items="${listOrder}" var="order">
                    <div id="order-area-${order.orderID}" class="order my-3 bg-light">
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
                                    <button onclick="viewDetailOrder('<c:url value="/api/list-order-detail/${order.orderID}"/>', '${totalPrice}')" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#modal-detail-order">View Detail</button>
                                    <button onclick="changeStateOrder('<c:url value="/api/change-state-order/${order.orderID}/"/>')" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#modal-change-state-order">Change State</button>
                                    <div style="display: none" id="sp-wait-change-delete-order-${order.orderID}" class="spinner-border"></div>
                                    <button onclick="deleteOrder(this,'<c:url value="/api/order/${order.orderID}"/>',${order.orderID})" class="btn btn-outline-dark">Cancel Order</button>
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
<!-- The Modal -->
<div class="modal fade" id="modal-change-state-order">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">Change State Order</span></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <input value="" id="input-orderid-area" style="display: none" type="text"/>
                <select id="select-order-state">
                    <option value="0">Choose a state</option>
                    <c:forEach items="${listOrderState}" var="os">
                        <option value="${os.osID}">${os.name}</option>
                    </c:forEach>
                </select>
                <div style="display: none" id="sp-wait-order-in-modal" class="spinner-border"></div>
                <button onclick="changeStateOrderSubmit(this)" class="btn btn-dark">Change</button>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>