<%-- 
    Document   : add-product
    Created on : 24 Aug 2022, 01:47:24
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">Edit Sale Post</p>
                    <c:url value="/manager/edit-post/${editSalePost.postID}" var="url"/>
                    <form:form cssClass="mx-1 mx-md-4" method="post" action="${url}" modelAttribute="salePost" enctype="multipart/form-data">
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <div style="margin-left: 40%;margin-bottom: 10px">
                                    <img width="50px" height="50px" src="${editSalePost.avatar}" alt="alt"/>
                                </div>
                                <form:input id="e-salepost-avatar" path="fileAvatar" type = "file" cssClass="form-control"/>
                                <label class="fw-bold form-label" for="e-salepost-avatar">Avatar</label>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-heading fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input value="${editSalePost.title}" id="e-salepost-title" path="title" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="title"/>
                                <label class="fw-bold form-label" for="e-salepost-title">Title</label>
                            </div>
                        </div>
                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-info-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:select id="e-salepost-saleStatus" path="saleStatus" type = "text" cssClass="form-control">
                                        <option value="0" selected>Choose a status</option>
                                        <c:forEach items="${listSaleStatus}" var="s">
                                            <c:if test="${s.stID eq editSalePost.saleStatus.stID}">
                                                <option selected value="${s.stID}">${s.name}</option>
                                            </c:if>
                                            <c:if test="${s.stID != editSalePost.saleStatus.stID}">
                                                <option value="${s.stID}">${s.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors cssClass="text-danger" element="div" path="saleStatus"/>
                                    <label class="fw-bold form-label" for="e-salepost-saleStatus">Sale Status</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-info-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:select id="e-salepost-categoryID" path="categoryID" type = "text" cssClass="form-control">
                                        <form:errors cssClass="text-danger" element="div" path="*"/>
                                        <option value="0" selected>Choose a field</option>
                                        <c:forEach items="${listCategories}" var="c">
                                            <c:if test="${c.categoryID eq editSalePost.categoryID.categoryID}">
                                                <option selected value="${c.categoryID}">${c.name}</option>
                                            </c:if>
                                            <c:if test="${c.categoryID != editSalePost.categoryID.categoryID}">
                                                <option value="${c.categoryID}">${c.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors cssClass="text-danger" element="div" path="categoryID"/>
                                    <label class=" fw-bold form-label" for="e-salepost-categoryID">Category</label>
                                </div>
                            </div>
                        </div>
                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${editSalePost.initialPrice}" var="ip"/> 
                                    <form:input placeholder="${ip} VND" id="e-salepost-initialPrice" path="initialPrice" type = "number" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="initialPrice"/>
                                    <label class=" fw-bold form-label" for="e-salepost-initialPrice">Initial Price</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${editSalePost.finalPrice}" var="fp"/>
                                    <form:input  placeholder="${fp} VND"  id="e-salepost-finalPrice" path="finalPrice" type = "number" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="finalPrice"/>
                                    <label class="fw-bold form-label" for="e-salepost-finalPrice">Final Price</label>
                                </div>
                            </div>
                        </div>
                        <div class="row d-flex flex-row align-items-center mb-2">
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-flag fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input value="${editSalePost.origin}" id="e-salepost-origin" path="origin" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="origin"/>
                                    <label class="fw-bold form-label" for="e-salepost-origin">Origin</label>
                                </div>
                            </div>
                            <div class="col-md-6 d-flex flex-row align-items-center mb-2">
                                <i class="fas fa-copyright fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input value="${editSalePost.brand}" id="e-salepost-brand" path="brand" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="brand"/>
                                    <label class=" fw-bold form-label" for="e-salepost-brand">Brand</label>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-industry fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input value="${editSalePost.manufacturer}" id="e-salepost-manufacturer" path="manufacturer" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="manufacturer"/>
                                <label class="fw-bold form-label" for="e-salepost-manufacturer">Manufacturer</label>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-2">
                            <i class="fas fa-info fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                                <form:input value="${editSalePost.description}" id="e-salepost-description" path="description" type = "text" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" element="div" path="description"/>
                                <label class=" fw-bold form-label" for="e-salepost-description">Description</label>
                            </div>
                        </div>
                        <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                            Edit Sale Post Information
                        </button>
                    </form:form>
                </div>
                <div class="col-md-10 col-lg-4 col-xl-4 d-flex align-items-center order-1 order-lg-2">

                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661238919/Online_Groceries-cuate_j5hnif.png"
                         class="img-fluid" alt="Sample image">

                </div>

            </div>
            <hr/>
            <div style="margin-top: 50px" class="row justify-content-center">
                <div class="col-md-8 col-8">
                    <p class="text-center h3 fw-bold mb-2 mx-1 mx-md-4 mt-4 text-uppercase">List Items</p>
                    <button style="width: 30%;margin-left: 35%" onclick="addItemForSalePost('<c:url value="/api/add-item/${editSalePost.postID}"/>')" class="btn btn-outline-dark btn-sm mb-2" type="button">Add items</button>
                    <c:if test="${editSalePost.itemSet.size() == 0}">
                        <div style="margin-top: 50px;" class="col-12 col-md-12">
                            <span class="badge bg-dark text-center"><h6>Empty <div class="spinner-border spinner-border-sm text-light"></div></h6></span>
                        </div>
                    </c:if>
                    <c:forEach items="${editSalePost.itemSet}" var="item">
                        <div id="item-salepost-${item.itemID}" class="row justify-content-center mb-3">
                            <div class="col-md-12 col-xl-10">
                                <div class="card shadow-0 border rounded-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                    <div>
                                                        <img src="${item.avatar}"
                                                             class="w-100 h-100" />
                                                    </div>
                                                    <a href="#!">
                                                        <div class="hover-overlay">
                                                            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 col-xl-6">
                                                <h5 class="text-uppercase fw-bold">${item.name}</h5>
                                                <h6 class="text text-danger fw-bold"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.unitPrice}"/> VND</h6>
                                                <h6  class="text text-dark fw-bold">Inventory: <span class="fw-bold">${item.inventory}</span></h6>
                                                <h6 class="text text-dark fw-bold">${item.description}</h6>
                                            </div>
                                            <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                                <div class="d-flex flex-column mt-2">
                                                    <button onclick="updateItemForSalePost('<c:url value="/api/update-item/${item.itemID}"/>','<c:url value="/api/get-item/${item.itemID}"/>')" class="btn btn-outline-dark btn-sm"  type="button">Edit Item</button>
                                                    <button onclick="deleteItemSalePost(this, '<c:url value="/api/item-salepost/${item.itemID}"/>', ${item.itemID})"  class="btn btn-outline-dark btn-sm mt-2" type="button">Delete</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-md-4 col-4">
                    <p class="text-center h3 fw-bold mb-2 mx-1 mx-md-4 mt-4 text-uppercase">Picture Set</p>
                    <button style="width: 60%;margin-left: 20%" onclick="openModalUpLoadMultiple('<c:url value="/api/add-picture-set/${editSalePost.postID}"/>')" class="btn btn-outline-dark btn-sm  mb-2" type="button">Add Picture Set</button>
                    <c:if test="${editSalePost.picturePostSet.size() == 0}">
                        <div style="margin-top: 50px;" class="col-12 col-md-12">
                            <span class="badge bg-dark text-center"><h6>Empty <div class="spinner-border spinner-border-sm text-light"></div></h6></span>
                        </div>
                    </c:if>
                    <c:forEach items="${editSalePost.picturePostSet}" var="pic">
                        <div id="picture-salepost-${pic.picID}" class="row justify-content-center mb-3">
                            <div class="col-md-12 col-xl-10">
                                <div class="card shadow-0 border rounded-3">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12 col-lg-6 col-xl-6 mb-4 mb-lg-0">
                                                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                    <div>
                                                        <img src="${pic.image}"
                                                             class="w-50 h-50" />
                                                    </div>
                                                    <a href="#!">
                                                        <div class="hover-overlay">
                                                            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-12 col-lg-6 col-xl-6 border-sm-start-none border-start">
                                                <div class="d-flex flex-column mt-2">
                                                    <div id="sp-delete-pic-post-${pic.picID}" style="display: none" class="spinner-border"></div>
                                                    <button onclick="deleteImageSalePost(this, '<c:url value="/api/picture-salepost/${pic.picID}"/>', ${pic.picID})" class="btn btn-outline-dark btn-sm mt-2" type="button">Delete</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

