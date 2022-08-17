<%-- 
    Document   : test
    Created on : 8 Aug 2022, 13:26:21
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>test view ne</h1>
 <h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>
  <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/ou-ecommerce&response_type=code
    &client_id=405256729803-ldem34qntvtuhmtenig599itet2489ga.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
 