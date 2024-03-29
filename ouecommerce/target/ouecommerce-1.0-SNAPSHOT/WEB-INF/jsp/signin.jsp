<%-- 
    Document   : signin
    Created on : 8 Aug 2022, 18:59:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div style="margin-bottom: 100px;margin-top: 50px"class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
            <img src="https://res.cloudinary.com/dec25/image/upload/v1659971643/Ecommerce_web_page-bro_n6p3vt.png"
                 class="img-fluid" alt="Sample image">
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"><spring:message code="label.signin.title"/></p>
            <c:url value="/sign-in" var="urlLogin"/>
            <form action="${urlLogin}" method="post">
                <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                    <p class="fw-bold lead fw-normal mb-0 me-3"><spring:message code="label.signin.with"/></p>
                        <a  class="btn btn-primary btn-floating mx-1" style="text-decoration: none;color: white" href="https://www.facebook.com/dialog/oauth?scope=email&client_id=555265043013184&redirect_uri=http://localhost:8080/ou-ecommerce/login-facebook"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-danger btn-floating mx-1" style="text-decoration: none;color: white" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/ou-ecommerce/login-google&response_type=code
                           &client_id=405256729803-ldem34qntvtuhmtenig599itet2489ga.apps.googleusercontent.com&approval_prompt=force"><i class="fab fa-google"></i></a>
                </div>
                <c:if test="${param.error != null || param.accessDenied != null }">
                    <div style="margin-top: 10px" class="alert alert-danger">
                        <c:if test="${param.error != null}">
                            <c:if test="${err_ms != null}">
                                <spring:message code="message.err.signin.emailExist" />
                            </c:if>
                            <c:if test="${err_ms == null}">
                                <spring:message code="message.err.signin.failed" />
                            </c:if>
                        </c:if>
                        <c:if test="${param.accessDenied != null}">
                            <spring:message code="message.err.signin.accessDenied" />
                        </c:if>
                    </div>   
                </c:if>

                <div class="divider d-flex align-items-center my-4">
                    <p class="text-center fw-bold mx-3 mb-0"><spring:message code="label.signin.orWith"/><span class="text-danger fw-bold"> OU ECOMMERCE</span></p>
                </div>
                <!-- Username input -->
                <div class="form-outline mb-4">
                    <input name="username" type="text" id="username" class="form-control form-control-lg"
                           placeholder="Enter username" />
                    <label class="fw-bold form-label" for="username"><spring:message code="label.signin.username"/></label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-3">
                    <input name="password" type="password" id="password" class="form-control form-control-lg"
                           placeholder="Enter password" />
                    <label class="fw-bold form-label" for="password"><spring:message code="label.signin.password"/></label>
                </div>

                <div class="d-flex justify-content-between align-items-center">
                    <a href="#" class="text-body"><spring:message code="label.signin.forgotPassword"/></a>
                </div>

                <div class="text-center text-lg-start mt-4 pt-2">
                    <button type="submit" class="btn btn-dark btn-lg"
                            style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                    <p class="small fw-bold mt-2 pt-1 mb-0"><spring:message code="label.signin.createAccount"/> <a href="<c:url value="/sign-up"/>"
                                                                                      class="link-danger"><spring:message code="label.signin.signup"/></a></p>
                </div>

            </form>
        </div>
    </div>
</div>
