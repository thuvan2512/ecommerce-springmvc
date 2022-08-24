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
                    <div class="p-4 text-black" style="background-color:#dfe6e9;">
                        <div class="d-flex justify-content-end text-center py-1">
                            <div class="px-4">
                                <p class="mb-1 h5">${countProducts}</p>
                                <p class="small text-muted mb-0">Sale Post(s)</p>
                            </div>
                            <div class="px-4">
                                <p class="mb-1 h5">${countLike}</p>
                                <p class="small text-muted mb-0">Like(s)</p>
                            </div>
                            <div class="px-4">
                                <p class="mb-1 h5">${countSold}</p>
                                <p class="small text-muted mb-0">Sold</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-body p-4 text-black">
                        <div class="mb-5">
                            <p class="lead fw-normal mb-1">About</p>
                            <div class="p-4" style="background-color: #dfe6e9;">
                                <p class="font-italic mb-1">Manager: <span class="fw-bold">${agency.manager.username}</span></p>
                                <p class="font-italic mb-1">Agent Field: ${agency.field.name}</p>
                                <p class="font-italic mb-1">Created Date: <fmt:formatDate pattern = "dd/MM/yyyy" value = "${agency.createdDate}"/></p>
                                <p class="font-italic mb-1">Hotline: ${agency.hotline}</p>
                                <p class="font-italic mb-1">Address:  ${agency.address}</p>
                                <c:url value="/manager/edit-agency" var="editAgency"/>
                                <button onclick="redirectToUrl('${editAgency}')" style="margin-top: 10px"class="btn btn-dark">Edit Agency Info</button>
                            </div>

                        </div>

                    </div>
                    <div class="card-body p-4 text-black">
                        <p class="lead fw-normal mb-1">Top seller</p>
                    </div>
                    <div class="table-wishlist" style="background-color: #dfe6e9">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                            <thead>
                                <tr>
                                    <th width="5%" class="text-center"></th>
                                    <th width="30%" class="text-center fw-bold">Product Name</th>
                                    <th width="25%" class="text-center fw-bold">Description</th>
                                    <th width="20%" class="text-center fw-bold">Price</th>
                                    <th width="10%" class="text-center fw-bold">In Stock</th>
                                    <th width="10%" class="text-center fw-bold">Sold</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${topSeller}" varStatus="loops">
                                    <tr>
                                        <td class="text-center fw-bold">
                                            ${loops.index + 1}
                                        </td>
                                        <td width="30%">
                                            <div class="display-flex align-center">
                                                <div class="img-product">
                                                    <img src="${i[0]}" alt="" class="mCS_img_loaded">
                                                </div>
                                                <div class="name-product fw-bold">
                                                    ${i[2]}
                                                </div>
                                            </div>
                                        </td>
                                        <td width="25%" class="text-center">${i[5]}</td>
                                        <td width="20%" class="text-center"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${i[3]}"/> VND</td>
                                        <td width="10%" class="text-center">${i[6]}</td>
                                        <td width="10%" class="text-center">${i[4]}</td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
