<%-- 
    Document   : base
    Created on : 3 Aug 2022, 15:35:40
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <c:url value="/css/style.css" var="css"/>
        <c:url value="/js/scripts.js" var="scripts"/>
        <c:url value="/images/logo/logo.png" var="logo"/>
        <%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <link href="${css}" rel="stylesheet" >
        <script src="${scripts}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
        <title><tiles:insertAttribute name="title"/></title>
        <link rel = "icon" href = "${logo}" />
    </head>
    <body>
        <!-- Back to Top -->
        <div>
            <a style="display: none"class="button-go-to-top btn btn-danger" onclick="topFunction()">
                <i class="fas fa-angle-double-up"></i>
            </a>
        </div>
        <!-- The Modal quick view -->
        <div class="modal" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><span class=" badge bg-dark text-uppercase fw-bold m-1">Quick View</span></h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div id="modal-quickview" class="modal-body">
                        <div id="spinner-loadquickview" class="spinner-border text-danger"></div>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
    <!<!-- modal quick view end -->

    <!-- The Modal add to cart -->
    <div class="modal" id="myModalAddToCart">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Add To Cart</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    cart
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>
    <!<!-- modal add to cart end -->
    <tiles:insertAttribute name="header"/>
    <div>
        <tiles:insertAttribute name="content"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</body>
</html>
