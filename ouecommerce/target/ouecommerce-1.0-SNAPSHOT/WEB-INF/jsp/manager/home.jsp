<%-- 
    Document   : manager
    Created on : 24 Aug 2022, 02:05:57
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row col-md-12 col-12">
    <div class="container py-1 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-12 col-xl-12">
                <div class="card">
                    <div class="rounded-top text-white d-flex flex-row" style="background-color: #212529; height:300px;">
                        <div class="ms-5 mt-5 d-flex flex-column" style="width: 150px;">
                            <div style="width: 150px;height: 150px; z-index: 1">
                                <img src="${agency.avatar}"
                                     alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                                     >
                            </div>
                        </div>
                        <div class="ms-5" style="margin-top: 130px;">
                            <h3 class="fw-bold">${agency.name} </h3>
                            <p>${agency.field.name}</p>
                        </div>
                    </div>
                    <div class="p-4 text-black main-content">
                        <div class="d-flex my-4 flex-wrap">
                            <div class="box me-4 my-1 bg-light">
                                <img src="https://res.cloudinary.com/dec25/image/upload/v1661752432/gallery_x7mxl7.png"
                                     alt="">
                                <div class="d-flex align-items-center mt-2">
                                    <div class="tag">Sale post(s)</div>
                                    <div class="ms-auto number">${countProducts}</div>
                                </div>
                            </div>
                            <div class="box me-4 my-1 bg-light">
                                <img src="https://res.cloudinary.com/dec25/image/upload/v1661752602/online-shopping_wqanzo.png"
                                     alt="">
                                <div class="d-flex align-items-center mt-2">
                                    <div class="tag">Quantity sold</div>
                                    <div class="ms-auto number">${countSold}</div>
                                </div>
                            </div>
                            <div class="box me-4 my-1 bg-light">
                                <img src="https://res.cloudinary.com/dec25/image/upload/v1661752526/1244038_xgdn2l.png"
                                     alt="">
                                <div class="d-flex align-items-center mt-2">
                                    <div class="tag">Total like</div>
                                    <div class="ms-auto number">${countLike}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body p-4 text-black row">
                        <div class="mb-5 col-md-8 col-8">
                            <p class="lead fw-normal mb-1">About</p>
                            <div class="p-4" >
                                <p class="font-italic mb-1">Manager: <span class="fw-bold">${agency.manager.username}</span></p>
                                <c:if test="${agency.isActive == 0}"><p class="font-italic mb-1">State:<span class="fw-bold"> Banned from operation</span></p></c:if>
                                <c:if test="${agency.isActive == 1}"><p class="font-italic mb-1">State:<span class="fw-bold"> Active</span></p></c:if>
                                <p class="font-italic mb-1">Agent Field: ${agency.field.name}</p>
                                <p class="font-italic mb-1">Created Date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${agency.createdDate}"/></p>
                                <p class="font-italic mb-1">Hotline: ${agency.hotline}</p>
                                <p class="font-italic mb-1">Address:  ${agency.address}</p>
                                <c:url value="/manager/edit-agency" var="editAgency"/>
                                <button onclick="redirectToUrl('${editAgency}')" style="margin-top: 10px"class="btn btn-dark">Edit Agency Info</button>
                            </div>

                        </div>
                        <div class="col-4 col-md-4">

                            <img src="https://res.cloudinary.com/dec25/image/upload/v1661238919/Online_Groceries-pana_vg128j.png"
                                 class="img-fluid" alt="Sample image">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
