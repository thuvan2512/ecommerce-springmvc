<%-- 
    Document   : register-agency
    Created on : 22 Aug 2022, 09:15:35
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/user/register-agency" var="url"/>
<div class="row d-flex justify-content-center align-items-center h-100">
    <div class="col-lg-12 col-xl-11">
        <div class=" text-black">
            <div class="card-body p-md-5">
                <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                        <c:if test="${err_ms != null}">
                            <div class="alert alert-danger">
                                ${err_ms}
                            </div>
                        </c:if>
                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register Agency</p>

                        <form:form cssClass="mx-1 mx-md-4" method="post" action="${url}" modelAttribute="agent" enctype="multipart/form-data">
                            <form:errors cssClass="text-danger" element="div" path="*"/>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="a-avatar" path="fileAvatar" type = "file" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="fileAvatar"/>
                                    <label class="fw-bold form-label" for="a-avatar">Avatar</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-store fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="a-name" path="name" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="name"/>
                                    <label class="fw-bold form-label" for="a-name">Name of agency</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-tshirt fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:select id="a-field" path="field" type = "text" cssClass="form-control">
                                        <option value="0" selected>Choose a field</option>
                                        <c:forEach items="${field}" var="f">
                                            <option value="${f.afID}">${f.name}</option>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors cssClass="text-danger" element="div" path="field"/>
                                    <label class="fw-bold form-label" for="a-field">Agency Field</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-map-marker-alt fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="a-address" path="address" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="address"/>
                                    <label class="fw-bold form-label" for="a-address">Address</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-phone-alt fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="hotline" path="hotline" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="hotline"/>
                                    <label class="fw-bold form-label" for="hotline">Hotline</label>
                                </div>
                            </div>
                            <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                                Register To Become Our Partner
                            </button>
                        </form:form>
                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                        <img src="https://res.cloudinary.com/dec25/image/upload/v1661217070/Online_shopping-bro_dwlqld.png"
                             class="img-fluid" alt="Sample image">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
