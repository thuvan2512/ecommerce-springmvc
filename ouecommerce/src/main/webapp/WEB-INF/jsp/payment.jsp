<%-- 
    Document   : payment
    Created on : 18 Aug 2022, 13:24:03
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="card">
            <div class="card-body">
                <div class="row d-flex justify-content-center pb-5">
                    <div class="col-md-7 col-xl-5 mb-4 mb-md-0">
                        <div class="py-4 d-flex flex-row">
                            <h5><span class="far fa-check-square pe-2"></span><b>Ecommerce OU</b> |</h5>
                            <span class="ps-2">Pay</span>
                        </div>
                        <hr />
                        <div class="pt-2">
                            <p class="text-dark fw-bold">
                                <i class="fas fa-user"></i> &nbsp;<spring:message code="label.payment.cusInfo"/>:
                            </p>
                            <h6 class="fw-bold text-dark">Username: ${customer.username}</h6>
                            <h6 class="fw-bold text-dark">Email: ${customer.email}</h6>
                            <h6 class="fw-bold text-dark">Address: ${customer.address}</h6>
                            <hr />
                            <form class="pb-3">
                                <div class="d-flex flex-row pb-3">
                                    <div class="d-flex align-items-center pe-2">
                                        <input class="form-check-input" type="radio" name="rdPaymentType" id="radioNoLabel1"
                                               value="1" aria-label="..." checked />
                                    </div>
                                    <div class="rounded border d-flex w-100 p-3 align-items-center">
                                        <p class="mb-0">
                                            <i class="fas fa-truck"></i> &nbsp;<spring:message code="label.payment.byCash"/>
                                        </p>
                                    </div>
                                </div>

                                <div class="d-flex flex-row">
                                    <div class="d-flex align-items-center pe-2">
                                        <input class="form-check-input" type="radio" name="rdPaymentType" id="radioNoLabel2"
                                               value="2" aria-label="..." />
                                    </div>
                                    <div class="rounded border d-flex w-100 p-3 align-items-center">
                                        <p class="mb-0">
                                            <i class="fas fa-wallet"></i> &nbsp;<spring:message code="label.payment.byMoMo"/>
                                        </p>
                                    </div>
                                </div>
                            </form>
                            <c:url value="/api/payment" var="pay"/>
                            <c:url value="/" var="context"/>
                            <c:url value="/payment/result" var="redirect"/>
                            <div id="sp-payment-load" style="display: none" class="spinner-border text-dark"></div>
                            <input id="btn-payment" onclick="payment('${pay}','${context}','${redirect}')" type="button" value="<spring:message code="label.payment.proceed"/>" class="btn btn-dark btn-block btn-lg" />
                        </div>
                    </div>

                    <div class="col-md-5 col-xl-4 offset-xl-1">
                        <div class="py-4 d-flex justify-content-end">
                            <h6><a style="text-decoration: none" href="<c:url value="/"/>"><i class="fas fa-arrow-left"></i> &nbsp;<spring:message code="label.payment.cancel"/></a></h6>
                        </div>
                        <div class="rounded d-flex flex-column p-2" style="background-color: #f8f9fa;">
                            <div class="p-2 me-3">
                                <h4><spring:message code="label.payment.order.orderRecap"/></h4>
                            </div>
                            <div class="p-2 d-flex">
                                <div class="col-8"><spring:message code="label.payment.order.quantity"/></div>
                                <div class="ms-auto">${countItems} item(s)</div>
                            </div>
                            <div class="p-2 d-flex">
                                <div class="col-8"><spring:message code="label.payment.order.temporary"/></div>
                                <div class="ms-auto"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${total}"/> VND</div>
                            </div>
                            <div class="p-2 d-flex">
                                <div class="col-8"><spring:message code="label.payment.order.discount"/></div>
                                <div class="ms-auto">0 VND</div>
                            </div>
                            <div class="border-top px-2 mx-2"></div>
                            <div class="p-2 d-flex pt-3">
                                <div class="col-8"><b><spring:message code="label.payment.order.total"/></b></div>
                                <div class="ms-auto"><b class="text-success"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${total}"/> VND</b></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
