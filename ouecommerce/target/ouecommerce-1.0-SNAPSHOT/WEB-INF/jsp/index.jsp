<%-- 
    Document   : index
    Created on : 1 Aug 2022, 09:34:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<script>
    window.onload = function () {
        clickPage(${page});
    <c:forEach items="${wishlist}" var="wl">
        if (document.getElementById(`btn-wishlist<c:out value="${wl.postID.postID}"/>`) != null) {
            document.getElementById(`btn-wishlist<c:out value="${wl.postID.postID}"/>`).style.color = "#D10024";
        }
    </c:forEach>
    }
</script>
<div class="content">
    <!-- Carousel  -->           
    <div class="banner">
        <div id="main-carou" class="carousel slide" data-bs-ride="carousel">

            <!-- Indicators/dots -->
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#main-carou" data-bs-slide-to="0" class="active"></button>
                <button type="button" data-bs-target="#main-carou" data-bs-slide-to="1"></button>
                <button type="button" data-bs-target="#main-carou" data-bs-slide-to="2"></button>
            </div>

            <!-- The slideshow/carousel -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1659368148/banner1_vwoq9i.jpg" alt="banner1" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1659368148/banner3_qv2fxw.jpg" alt="banner2" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1659368148/banner2_wcxvyj.jpg" alt="banner3" class="d-block w-100">
                </div>
            </div>

            <!-- Left and right controls/icons -->
            <button class="carousel-control-prev" type="button" data-bs-target="#main-carou" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#main-carou" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
            </button>
        </div>
    </div>
    <!-- Carousel -->
    <!-- Featured-bar  -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-check text-dark m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-3">High Quality</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-shipping-fast text-dark m-0 mr-2"></h1>
                    <h5 class="font-weight-semi-bold m-3">Free Ship</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fas fa-exchange-alt text-dark m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-3">14-Days Return</h5>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                    <h1 class="fa fa-phone-volume text-dark m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-3">24/7 Support</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured-bar end -->
    <!--Product area -->
    <div class="show-item container-fluid">
        <div class="row">
            <div class="col-md-4 col-12" >
                <h2 id="product-area" class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1">Featured Products</span></h2>
            </div>
            <div class="col-md-8">
                <div class="block-27">
                    <c:if test = "${not fn:contains(currentURL, 'search')}">
                        <ul class="pagination justify-content-end" style="margin:auto 40%">
                            <li class = "disabled" ><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
                                    <c:forEach begin="1" end="5" var="i">
                                        <c:url value="/" var="p">
                                            <c:param value="${i}" name="page"  />
                                        </c:url>
                                <li id="${i}" class="page-button"><a href="${p}">${i}</a></li>
                                </c:forEach>


                            <li class = "disabled"><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
                        </ul>
                    </c:if>
                    <c:if test = "${ fn:contains(currentURL, 'search')}">
                        <ul class="pagination justify-content-end" style="margin:auto 40%">
                            <li class = "disabled" ><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
                                    <c:if test="${countPage <= 5}">
                                        <c:forEach begin="1" end="5" var="i">
                                            <c:url value="/search" var="p">
                                                <c:param value="${i}" name="page"  />
                                            </c:url>
                                    <li id="${i}" class="page-button"><a href="${p}${currentParams}">${i}</a></li>
                                    </c:forEach>

                            </c:if>

                            <li class = "disabled"><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-4 container-fluid">
                <div class="row">
                    <div style="margin-top: 20px"class="col-12 col-md-12">
                        <h5 style="margin-bottom: 15px" class="text text-center fw-bold">Filter Results</h5> 
                    </div>
                </div>
                <form action="<c:url value="/search"/>">
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #212529;color: white" class="card-header">
                                <h6 class="title fw-bold">By price range </h6>
                            </header>
                            <div style="background-color: #ecf0f1" class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row">
                                        <div class="form-group col-12 col-md-6">
                                            <label for="min-price" class="text text-dark">Minimum price</label>
                                            <input min="0" name="fprice" type="number" class="form-control" id="min-price" placeholder="0 VND">
                                        </div>
                                        <div class="form-group col-12 col-md-6 text-right">
                                            <label  for="max-price"class="text text-dark">Maximum price</label>
                                            <input min="0" name="tprice" type="number" class="form-control" id="max-price"placeholder="10,000 VND">
                                        </div>
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div> <!-- card.// -->
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #212529;color: white" class="card-header">
                                <h6 class="title fw-bold">By date </h6>
                            </header>
                            <div style="background-color: #ecf0f1" class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row">
                                        <div class="form-group col-md-6">
                                            <label for="fdate" class="text text-dark">From date</label>
                                            <input type="date" id="fdate" name="fdate">
                                        </div>
                                        <div class="form-group col-md-6 text-right">
                                            <label for="tdate" class="text text-dark">To date</label>
                                            <input type="date" id="tdate" name="tdate">
                                        </div>                             
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div> <!-- card.// -->
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #212529;color: white" class="card-header">
                                <h6 class="title fw-bold">By status </h6>
                            </header>
                            <div style="background-color: #ecf0f1" class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row container-fluid">
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="instock" class="form-check-input" type="checkbox" id="in-stock" value="1">
                                            <label class="form-check-label" for="in-stock">In stock</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="bestseller" class="form-check-input" type="checkbox" id="best-seller" value="1">
                                            <label  class="form-check-label" for="best-seller">Best seller</label>
                                        </div>
                                        <div  style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="trending" class="form-check-input" type="checkbox" id="new" value="1">
                                            <label class="form-check-label" for="new">Trending</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="promotion" class="form-check-input" type="checkbox" id="promotion" value="1">
                                            <label class="form-check-label" for="shop-follow">Promotion</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="freeship" class="form-check-input" type="checkbox" id="free-ship" value="1">
                                            <label class="form-check-label" for="shop-follow">Free ship</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input name="superpromo" class="form-check-input" type="checkbox" id="super-promotion" value="1">
                                            <label class="form-check-label" for="shop-follow">Supersale</label>
                                        </div>

                                        <div class=" col-12 col-md-12">
                                            <button style="width: 60%;margin-left: 20%;margin-top: 15px"class="btn btn-danger">Start filter</button>
                                        </div>
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div> <!-- card.// -->
                </form>
                <hr style="width: 80%; margin-left: 10%;margin-top: 30px;"/>
                <h5 style="margin-left: 10px;margin-top: 30px;margin-bottom: 15px;"class="text text-center fw-bold">Compare Items</h5> 
                <div class="card" >
                    <article class="card-group-item">
                        <header  style="background-color: #212529;color: white" class="card-header">
                            <h6 class="title fw-bold">Current item </h6>
                        </header>
                        <div style="background-color: #ecf0f1" class="filter-content">
                            <div class="card-body">
                                <div class="form-row row container-fluid">
                                    <div class=" col-12 col-md-12 form-check">
                                        <div id="spinner-compare1" style="display: none" class="spinner-border"></div>
                                        <h6 id="cp-name" class="fw-bold text-danger text-center"></h6>
                                        <h6 id="cp-origin" class="fw-bold text-center"></h6>
                                        <h6 id="cp-manufacturer" class="fw-bold text-center"></h6>
                                        <h6 id="cp-agency" class="fw-bold text-center"></h6>
                                        <h6 style="display: none" id="cp-url"></h6>
                                    </div>
                                </div>
                            </div> <!-- card-body.// -->
                            <button onclick="clearItem()"style="width: 60%;margin-left: 20%;margin-bottom: 10px "class="btn btn-danger">Clear current item</button>
                        </div>
                    </article> <!-- card-group-item.// -->
                </div>
            </div>
            <!-- Product-->
            <div class=" row col-md-9 col-sm-8">
                <c:if test="${listSalePost.size() == 0}">
                    <div style="margin-top: 50px;" class="col-12 col-md-12">
                        <span class="badge bg-dark text-center"><h6>Empty product list <div class="spinner-border spinner-border-sm text-light"></div></h6></span>
                    </div>
                </c:if>
                <c:forEach items="${listSalePost}" var="sp">
                    <c:url value="/api/salepost/${sp.postID}/" var="endpoint"/>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img ">
                                <img style="width: 100%;height: 220px" src="${sp.avatar}" alt="product-image">
                                <div class="product-label">
                                    <span class="new">${sp.saleStatus.name}</span>
                                    <span class="sold"><fmt:formatDate pattern = "dd/MM/yyyy" 
                                                    value = "${sp.createdDate}" /></span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">${sp.categoryID.name}</p>
                                <c:url value="/product/product-details/${sp.postID}" var="pDetails"/>
                                <h4 class="product-name"><a href="${pDetails}">${sp.title}</a></h4>
                                <h6 class="product-price"><del class="product-old-price">
                                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sp.initialPrice}"/> VND
                                    </del></h6>
                                <h6 class="product-price">
                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sp.finalPrice}" /> VND
                                </h6>
                                <div class="product-btns">
                                    <c:url value="/sign-in?accessDenied"  var="signin"/>
                                    <c:url value="/api/add-to-wishlist"  var="atw"/>
                                    <button id ="btn-wishlist${sp.postID}" onclick="addToWishList(this, '${pageContext.request.userPrincipal.name}', '${signin}',${sp.postID}, '${atw}')" class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button onclick="compareSalePost('${endpoint}')" class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button id="btn-compare"onclick="quickView('${endpoint}')" class="quick-view" data-bs-toggle="modal" data-bs-target="#myModal"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <c:url value="/api/list-items/${sp.postID}/" var="classifyapi"/>
                                <c:url value="/" var="context"/>
                                <button class="add-to-cart-btn" onclick="loadClassify('${endpoint}', '${classifyapi}', '${context}')" data-bs-toggle="modal" data-bs-target="#myModalAddToCart"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <!-- Product area end-->

    <!-- Categories -->
    <div id="categories" class="container-fluid pt-5">
        <h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1">Categories</span></h2>
        <div class="row px-xl-5 pb-3">
            <c:forEach items="${listCategories}" var="c">
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="<c:url value="/search">
                           <c:param name="category" value="${c.categoryID}"/>
                       </c:url>">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 120px; height: 120px;">
                                <img class="img-fluid" src="${c.avatar}" alt="cate-img">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">${c.name}</h6>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <!--  end -->
</div>
<!-- *****  Shop area ***** -->
<div style="margin-top: 15px"class="container-fluid">
    <h2 class="section-title position-relative mx-xl-5 mb-4"><span class=" badge bg-dark text-uppercase fw-bold m-1">Featured Shops</span></h2>
    <div class="main-banner" id="top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <div class="left-content">
                        <div class="thumb">
                            <img src="https://res.cloudinary.com/dec25/image/upload/v1659697387/Ecommerce_web_page-pana_sqplwp.png" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="right-content">
                        <div class="row">
                            <c:forEach begin="1" end="4">
                                <div class="col-lg-6">
                                    <div class="right-first-image">
                                        <div class="thumb">
                                            <div class="inner-content">
                                                <h4>Shop ABC</h4>
                                                <span>Number one in the world !!!</span>
                                            </div>
                                            <div class="hover-content">
                                                <div class="inner">
                                                    <h4>Shop ABC</h4>
                                                    <p>Lorem ipsum dolor sit amet, conservisii ctetur adipiscing elit incid.</p>
                                                    <div class="main-border-button">
                                                        <a href="#">Discover Now</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="https://technext.github.io/hexashop/assets/images/baner-right-image-04.jpg">
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Shop area end***** -->