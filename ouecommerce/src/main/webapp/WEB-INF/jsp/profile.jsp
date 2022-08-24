<%-- 
    Document   : profile
    Created on : 21 Aug 2022, 10:11:17
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/user/profile" var="url"/>
<form method="post" action="${url}" enctype="multipart/form-data">
    <div style="margin-bottom: 50px;margin-top: 20px;"class="row">
        <div class="col-xl-4">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Profile Picture</div>
                <div class="card-body text-center">
                    <!-- Profile picture image-->
                    <img src="${currentUser.avatar}" width="150px" height="150px" class="img-rounded" alt="Cinque Terre">
                    <!-- Profile picture help block-->
                    <input name="fileAvatar" style="margin-top: 20px" type="file"/>
                    <!-- Profile picture upload button-->
                </div>
            </div>
            <c:if test="${error_ms != null}">
                <div class="alert alert-danger">
                    ${error_ms}
                </div>
            </c:if>
            <c:if test="${ms != null}">
                <div class="alert alert-info">
                    ${ms}
                </div>
            </c:if>
        </div>
        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Account Details</div>
                <div class="card-body">
                    <form>
                        <!-- Form Group (username)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-4">
                                <label class="small mb-1" for="inputUsername">Username</label>
                                <input class="form-control" id="inputUsername" disabled type="text" placeholder="Enter your username" value="${currentUser.username}">
                            </div>

                            <div class="col-md-4">
                                <label class="small mb-1" for="inputFirstName">First name</label>
                                <input class="form-control" id="inputFirstName" name="firstname" type="text" placeholder="Enter your first name" value="${currentUser.firstName}">
                            </div>
                            <!-- Form Group (last name)-->
                            <div class="col-md-4">
                                <label class="small mb-1" for="inputLastName">Last name</label>
                                <input class="form-control" id="inputLastName" name="lastname" type="text" placeholder="Enter your last name" value="${currentUser.lastName}">
                            </div>
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (first name)-->
                            <div class="col-md-12">
                                <label class="small mb-1" for="inputLocation">Address</label>
                                <input class="form-control" id="inputLocation" name="address"type="text" placeholder="Enter your location" value="${currentUser.address}">
                            </div>
                        </div>
                        <c:if test="${currentUser.authProvider.authID == 1}">
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (phone number)-->
                                <!-- Form Group (birthday)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="newpass">Confirm Password</label>
                                    <input class="form-control" id="newpass" type="password" name="password" placeholder="Enter your password" />
                                </div>
                                <div class="col-md-6">
                                    <label class="small mb-1" for="confirm">Confirm Password</label>
                                    <input class="form-control" id="confirm" type="password" name="repassword" placeholder="Confirm your password" />
                                </div>
                            </div>
                        </c:if>
                        <!-- Save changes button-->
                        <button class="btn btn-dark" type="submit">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</form>