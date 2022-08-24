<%-- 
    Document   : signup
    Created on : 8 Aug 2022, 18:59:42
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/sign-up" var="url"/>
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
                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                        <form:form cssClass="mx-1 mx-md-4" method="post" action="${url}" modelAttribute="user" enctype="multipart/form-data">
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-user-circle fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="avatar" path="fileAvatar" type = "file" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="fileAvatar"/>
                                    <label class="fw-bold form-label" for="avatar">Avatar</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="email" path="email" type = "email" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="email"/>
                                    <label class="fw-bold form-label" for="email">Your Email</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="username" path="username" type = "text" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="username"/>
                                    <label class="fw-bold form-label" for="username">Username</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="password" path="password" type = "password" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="password"/>
                                    <label class="fw-bold form-label" for="password">Password</label>
                                </div>
                            </div>

                            <div class="d-flex flex-row align-items-center mb-4">
                                <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                <div class="form-outline flex-fill mb-0">
                                    <form:input id="confirm" path="rePassword" type = "password" cssClass="form-control"/>
                                    <form:errors cssClass="text-danger" element="div" path="rePassword"/>
                                    <label class="fw-bold form-label" for="confirm">Repeat your password</label>
                                </div>
                            </div>
                                <button class="w-100 py-2 mb-2 btn btn-dark" type="submit">
                                    Sign up with OU Account
                                </button>
                                    <h2 style="margin-top: 30px" class="fs-5 fw-bold mb-3">Or use a third-party</h2>
                            <button class="w-100 py-2 mb-2 btn btn-danger ">
                                <a style="text-decoration: none;" class="text-light" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/ou-ecommerce/login-google&response_type=code
                           &client_id=405256729803-ldem34qntvtuhmtenig599itet2489ga.apps.googleusercontent.com&approval_prompt=force">Sign up with Google</a>
                            </button>
                            <button class="w-100 py-2 mb-2 btn btn-primary">
                                <a style="text-decoration: none;" class="text-light" href="#">Sign up with Facebook</a>
                            </button>

                        </form:form>

                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                        <img src="https://res.cloudinary.com/dec25/image/upload/v1661217070/Online_shopping-cuate_d1rplu.png"
                             class="img-fluid" alt="Sample image">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
