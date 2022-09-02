<%-- 
    Document   : payment-result
    Created on : 25 Aug 2022, 16:10:00
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="margin-bottom: 100px;margin-top: 50px"class="container-fluid h-custom">
    <div class="row container-fluid d-flex justify-content-center align-items-center h-100">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 "><spring:message code="label.payment.result"/></p>
        <a  class="link-dark text-center h6 mx-1 mx-md-4 mt-2" href="<c:url value="/user/orders"/>"><spring:message code="label.payment.check"/></a>
        <div class="col-md-4 col-lg-4 col-xl-4">
            <img src="https://res.cloudinary.com/dec25/image/upload/v1661752976/In_no_time-pana_jy8dan.png"
                 class="img-fluid" alt="Sample image">
        </div>
    </div>
</div>

