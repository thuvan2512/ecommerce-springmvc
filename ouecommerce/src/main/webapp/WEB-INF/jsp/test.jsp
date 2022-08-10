<%-- 
    Document   : test
    Created on : 8 Aug 2022, 13:26:21
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>test view ne</h1>
<c:url value="/test" var="url"/>
<form:form method="post" action="${url}" modelAttribute="userTest" enctype="multipart/form-data">
    <form:errors cssClass="text-danger" element="div" path="*"/>
    <div class="form-group">
        <label for="avatar">Avatar: </label>
        <form:input id="avatar" path="fileAvatar" type = "file" cssClass="form-control"/>
        <label for="email">Mail: </label>
        <form:input id="email" path="email" type = "email" cssClass="form-control"/>
        <form:errors cssClass="text-danger" element="div" path="email"/>
        <label for="name">Username: </label>
        <form:input id="name" path="username" type = "text" cssClass="form-control"/>
        <form:errors cssClass="text-danger" element="div" path="username"/>
                <label for="pass">Username: </label>
        <form:input id="pass" path="password" type = "password" cssClass="form-control"/>
        <form:errors cssClass="text-danger" element="div" path="password"/>
    </div>password
    <div class="form-group">
        <input class="btn btn-danger" type="submit" value="test"/>
    </div>
</form:form>
    <h1>${user.avatar}</h1>