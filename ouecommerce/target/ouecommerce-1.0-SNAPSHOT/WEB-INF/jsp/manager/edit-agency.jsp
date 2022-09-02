<%-- 
    Document   : edit-agency
    Created on : 23 Aug 2022, 19:44:19
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row col-md-12 col-12">
    <div class="container py-5">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">Edit Agency Information</p>
        <div class="row justify-content-center">
            <div class="col-md-10 col-lg-6 col-xl-6 order-2 order-lg-1">
                <c:if test="${err_ms != null}">
                    <div class="alert alert-danger">
                        ${err_ms}
                    </div>
                </c:if>
                <c:url value="/manager/edit-agency" var="url"/>
                <form:form cssClass="mx-1 mx-md-4" method="post" action="${url}" modelAttribute="agent" enctype="multipart/form-data">
                    <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <div style="margin-left: 40%;margin-bottom: 10px">
                                <img width="50px" height="50px" src="${currentAgent.avatar}" alt="alt"/>
                            </div>
                            <form:input id="a-u-avatar" path="fileAvatarUpdate" type = "file" cssClass="form-control"/>
                            <form:errors cssClass="text-danger" element="div" path="fileAvatarUpdate"/>
                            <label class="fw-bold form-label" for="a-u-avatar">Avatar</label>
                        </div>
                    </div>
                    <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-store fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <form:input value = "${currentAgent.name}" id="a-u-name" path="name" type = "text" cssClass="form-control"/>
                            <form:errors cssClass="text-danger" element="div" path="name"/>
                            <label class="fw-bold form-label" for="a-u-name">Name of agency</label>
                        </div>
                    </div>
                    <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-tshirt fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <form:select id="a-u-field" path="field" type = "text" cssClass="form-control">
                                <option value="0">Choose a field</option>
                                <c:forEach items="${field}" var="f">
                                    <c:if test="${f.afID eq currentAgent.field.afID}">
                                        <option selected value="${f.afID}">${f.name}</option>
                                    </c:if>
                                    <c:if test="${f.afID != currentAgent.field.afID}">
                                        <option value="${f.afID}">${f.name}</option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                            <form:errors cssClass="text-danger" element="div" path="field"/>
                            <label class="fw-bold form-label" for="a-u-field">Agency Field</label>
                        </div>
                    </div>
                    <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-map-marker-alt fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <form:input value = "${currentAgent.address}" id="a-u-address" path="address" type = "text" cssClass="form-control"/>
                            <form:errors cssClass="text-danger" element="div" path="address"/>
                            <label class="fw-bold form-label" for="a-u-address">Address</label>
                        </div>
                    </div>
                    <div class="d-flex flex-row align-items-center mb-4">
                        <i class="fas fa-phone-alt fa-lg me-3 fa-fw"></i>
                        <div class="form-outline flex-fill mb-0">
                            <form:input value = "${currentAgent.hotline}" id="a-u-hotline" path="hotline" type = "text" cssClass="form-control"/>
                            <form:errors cssClass="text-danger" element="div" path="hotline"/>
                            <label class="fw-bold form-label" for="a-u-hotline">Hotline</label>
                        </div>
                    </div>
                    <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                        Edit Agency Info
                    </button>
                </form:form>
            </div>
            <div class="col-md-10 col-lg-6 col-xl-6 d-flex align-items-center order-1 order-lg-2">

                <img src="https://res.cloudinary.com/dec25/image/upload/v1659697387/Ecommerce_web_page-pana_sqplwp.png"
                     class="img-fluid" alt="Sample image">

            </div>
        </div>
    </div>
</div>