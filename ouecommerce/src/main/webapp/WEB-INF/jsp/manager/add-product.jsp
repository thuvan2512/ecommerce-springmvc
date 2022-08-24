<%-- 
    Document   : add-product
    Created on : 24 Aug 2022, 01:47:24
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row col-md-12 col-12">
    <div class=" text-black">
        <div class="card-body p-md-5">
            <div class="row justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-8 order-2 order-lg-1">
                    <c:if test="${err_ms != null}">
                        <div class="alert alert-danger">
                            ${err_ms}
                        </div>
                    </c:if>
                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">Post Product</p>
                    <c:url value="/manager/add-product" var="url"/>
                    <form:form cssClass="mx-1 mx-md-4" method="post" action="${url}" modelAttribute="salePost" enctype="multipart/form-data">
                        <form:errors cssClass="text-danger" element="div" path="*"/>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-heading fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input id="salepost-title" path="title" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="title"/>
                                <label class="fw-bold form-label" for="salepost-title">Title</label>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input id="salepost-avatar" path="fileAvatar" type = "file" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="fileAvatar"/>
                                <label class="fw-bold form-label" for="salepost-avatar">Avatar</label>
                            </div>
                        </div>

                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-info-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:select id="salepost-saleStatus" path="saleStatus" type = "text" cssClass="form-control">
                                        <option value="0" selected>Choose a status</option>
                                        <c:forEach items="${listSaleStatus}" var="s">
                                            <option value="${s.stID}">${s.name}</option>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors cssClass="text-danger" element="div" path="saleStatus"/>
                                    <label class="fw-bold form-label" for="salepost-saleStatus">Sale Status</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-info-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:select id="salepost-categoryID" path="categoryID" type = "text" cssClass="form-control">
                                        <option value="0" selected>Choose a field</option>
                                        <c:forEach items="${listCategories}" var="c">
                                            <option value="${c.categoryID}">${c.name}</option>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors cssClass="text-danger" element="div" path="categoryID"/>
                                    <label class=" fw-bold form-label" for="salepost-categoryID">Category</label>
                                </div>
                            </div>
                        </div>
                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="salepost-initialPrice" path="initialPrice" type = "number" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="initialPrice"/>
                                    <label class=" fw-bold form-label" for="salepost-initialPrice">Initial Price</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="salepost-finalPrice" path="finalPrice" type = "number" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="finalPrice"/>
                                    <label class="fw-bold form-label" for="salepost-finalPrice">Final Price</label>
                                </div>
                            </div>
                        </div>
                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-flag fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="salepost-origin" path="origin" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="origin"/>
                                    <label class="fw-bold form-label" for="salepost-origin">Origin</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-copyright fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="salepost-brand" path="brand" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="brand"/>
                                    <label class=" fw-bold form-label" for="salepost-brand">Brand</label>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-industry fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input id="salepost-manufacturer" path="manufacturer" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="manufacturer"/>
                                <label class="fw-bold form-label" for="salepost-manufacturer">Manufacturer</label>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-info fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input id="salepost-description" path="description" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="description"/>
                                <label class=" fw-bold form-label" for="salepost-description">Description</label>
                            </div>
                        </div>
                        <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                            Post Product For Sale
                        </button>
                    </form:form>
                </div>
                <div class="col-md-10 col-lg-4 col-xl-4 d-flex align-items-center order-1 order-lg-2">

                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661238919/Online_Groceries-cuate_j5hnif.png"
                         class="img-fluid" alt="Sample image">

                </div>
            </div>
        </div>
    </div>
</div>

