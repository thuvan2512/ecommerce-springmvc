<%-- 
    Document   : agency
    Created on : 30 Aug 2022, 11:15:36
    Author     : thu.nv2512
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row col-md-12 col-12">
    <div class="container py-5">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">Agency Management</p>
        <c:if test="${listAgency.size() == 0}">
            <div style="margin-top: 50px;" class="col-12 col-md-12">
                <span class="badge bg-dark text-center"><h6>Empty Agency list <div class="spinner-border spinner-border-sm text-light"></div></h6></span>
            </div>
        </c:if>
        <c:forEach items="${listAgency}" var="agency">
            <div id="agency-${agency.agencyID}" class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <div class="card shadow-0 border rounded-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                        <div>
                                            <img src="${agency.avatar}"
                                                 class="w-75 h-75" />
                                        </div>
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-uppercase fw-bold">${agency.name}</h5>
                                    <h6 class="text text-danger fw-bold">Manager: <span class="fw-bold">${agency.manager.username}</span></h6>
                                    <h6 class="text text-dark">Created date: <span class="fw-bold"><fmt:formatDate pattern = "dd/MM/yyyy" value = "${agency.createdDate}" /></span></h6>
                                    <h6 class="text text-dark">State: <span class="fw-bold">Active</span></h6>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-column mt-2">
                                        <button onclick="viewDetailAgency('<c:url value="/api/agency/${agency.agencyID}"/>')" class="btn btn-outline-dark btn-sm" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-view-details-agency" type="button">Quick View Detail</button>
                                        <button id="btn-view-detail-agency-stats-${agency.agencyID}" onclick="redirectToUrl('<c:url value="/admin/agency-stats/${agency.agencyID}"/>')" class="btn btn-outline-dark btn-sm mt-2" type="button">View Stats</button> 
                                        <div style="display: none" id="sp-wait-ban-agency-${agency.agencyID}" class="spinner-border"></div>
                                        <button onclick="banAgency('<c:url value="/api/ban-agency/${agency.agencyID}"/>', ${agency.agencyID}, this)"class="btn btn-outline-dark btn-sm mt-2" type="button">Ban Agency</button> 
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