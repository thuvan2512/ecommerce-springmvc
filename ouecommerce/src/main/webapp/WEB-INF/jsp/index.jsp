<%-- 
    Document   : index
    Created on : 1 Aug 2022, 09:34:56
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:url value="/css/style.css" var="css"/>
        <c:url value="/js/scripts.js" var="scripts"/>
        <c:url value="/images/logo/logo.png" var="logo"/>

        <link href="${css}" rel="stylesheet" >
        <script src="${scripts}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
        <title>OU E-Commerce</title>
        <link rel = "icon" href = "${logo}" />
    </head>
    <body>
        <nav id="navbar" class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">
                    <img src="${logo}" alt="Avatar Logo" style="width:40px;" class="rounded-pill"> 
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)"><i class="fas fa-home"></i> Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)"><i class="fas fa-th"></i> Featured</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)"><i class="fas fa-list-ul"></i> Categories</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-box-open"></i> Gallery</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"><i class="fas fa-store"></i> Follow</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-heart"></i> Wishlist</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-users"></i> About Us</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"><i class="fas fa-envelope-open-text"></i> Introduce</a>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-balance-scale"></i> Policy & Terms</a>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-phone-alt"></i> Contact</a>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-comment"></i> Feedback</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-headset"></i> Help & Support</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fas fa-user-alt"></i> Your Account</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"><i class="fas fa-id-badge"></i> View Profile</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-user-plus"></i> Sign Up</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-sign-in-alt"></i> Sign In</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt"></i> Sign Out</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">
                                <i class="fas fa-shopping-cart"></i>
                                <span> Cart </span> 
                                <span class="badge bg-danger">0</span>
                            </a>
                        </li>
                    </ul>
                    <div id ="search"  style="display: none">
                        <form class="d-flex">
                            <select name="category" class="form-select me-1">
                                <option value="all">All Categories</option>
                                <option value="1">Category 01</option>
                                <option value="2">Category 02</option>
                            </select>
                            <input name="kw" class="form-control me-2" type="text" placeholder="Search for products">
                            <input type="submit"  class="btn btn-danger" value="Search"/>
                        </form>
                        </di>
                    </div>
                </div>
        </nav>

        <!-- Back to Top -->
        <div>
            <a style="display: none"class="button-go-to-top btn btn-danger" onclick="topFunction()">
                <i class="fas fa-angle-double-up"></i>
            </a>
        </div>
        <!-- search  -->  
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="" class="text-decoration-none">
                    <span class="h1 text-uppercase fw-bold text-danger bg-dark px-2">OU</span>
                    <span class="h1 text-dark fw-bold text-uppercase bg-danger px-2 ml-n1">E-Commerce</span>
                </a>
            </div>
            <div class="col-lg-6 col-sm-8 col-9 text-left">
                <form >
                    <div class="input-group">
                        <div class="col-md-3">
                            <select name="category" id="cate" class="form-select">
                                <option value="all">All Categories</option>
                                <option value="1">Category 01</option>
                                <option value="2">Category 02</option>
                            </select>
                        </div>
                        <input type="text" name="kw" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group bg-transparent text-danger">
                                <input class="btn btn-danger" type="submit" value="Search"/>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-2 col-3 col-sm-4 text-right">
                <select class="form-select">
                    <option value="1" selected>
                        English (ENG)
                    </option>
                    <option value="2">
                        Vietnamese (VIE)
                    </option>
                </select>
            </div>
        </div>
        <!-- search  -->  
    </div>
    <div class="content">
        <!-- Carousel  -->           
        <div class="banner">
            <div id="demo" class="carousel slide" data-bs-ride="carousel">

                <!-- Indicators/dots -->
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
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
                <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
        </div>
        <!-- Carousel -->
        <!-- Featured  -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-check text-danger m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-3">High Quality</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-shipping-fast text-danger m-0 mr-2"></h1>
                        <h5 class="font-weight-semi-bold m-3">Free Ship</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fas fa-exchange-alt text-danger m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-3">14-Days Return</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-phone-volume text-danger m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-3">24/7 Support</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featured -->
        <!--show-items -->
        <div class="show-item container-fluid">
            <div class="row">
                <div class="col-md-4" >
                    <h3 class="section-title position-relative mx-xl-5 mb-4"><span class="text text-danger text-uppercase fw-bold m-1">Featured Products</span></h3>
                </div>
                <div class="col-md-8">
                    <div class="block-27">
                        <ul class="pagination justify-content-end" style="margin:auto 40%">
                            <li><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 col-sm-4 container-fluid">
                    <div class="row">
                        <div style="margin-top: 20px"class="col-12 col-md-12">
                            <h5 class="text text-center fw-bold">Filter Results</h5> 
                        </div>
                        <div style="margin-bottom: 10px;" class=" col-12 col-md-12">
                            <button style="width: 60%;margin-left: 20% "class="btn btn-danger">Start filter</button>
                        </div>
                    </div>
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #dfe6e9" class="card-header">
                                <h6 class="title fw-bold">By price range </h6>
                            </header>
                            <div class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row">
                                        <div class="form-group col-12 col-md-6">
                                            <label for="min-price" class="text text-dark">Minimum price</label>
                                            <input min="0" type="number" class="form-control" id="min-price" placeholder="0 VND">
                                        </div>
                                        <div class="form-group col-12 col-md-6 text-right">
                                            <label  for="max-price"class="text text-dark">Maximum price</label>
                                            <input min="0" type="number" class="form-control" id="max-price"placeholder="10,000 VND">
                                        </div>
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div> <!-- card.// -->
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #dfe6e9" class="card-header">
                                <h6 class="title fw-bold">By date </h6>
                            </header>
                            <div class="filter-content">
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
                            <header  style="background-color: #dfe6e9" class="card-header">
                                <h6 class="title fw-bold">By status </h6>
                            </header>
                            <div class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row container-fluid">
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input class="form-check-input" type="checkbox" id="in-stock" value="option1">
                                            <label class="form-check-label" for="in-stock">In stock</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input class="form-check-input" type="checkbox" id="best-seller" value="option2">
                                            <label class="form-check-label" for="best-seller">Best seller</label>
                                        </div>
                                        <div  style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input class="form-check-input" type="checkbox" id="new" value="option3">
                                            <label class="form-check-label" for="new">New</label>
                                        </div>
                                        <div style="margin-top: 15px" class=" col-12 col-md-6 form-check">
                                            <input class="form-check-input" type="checkbox" id="shop-follow" value="option4">
                                            <label class="form-check-label" for="shop-follow">Follow</label>
                                        </div>
                                        <div  style="margin-top: 15px" class=" col-12 col-md-12 form-check">
                                            <label class="form-check-label" for="label">Choose a label: </label>
                                            <select name="label" id="label">
                                                <option value="none" checked></option>
                                                <option value="volvo">Volvo</option>
                                                <option value="saab">Saab</option>
                                                <option value="mercedes">Mercedes</option>
                                                <option value="audi">Audi</option>
                                            </select>
                                        </div>
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div> <!-- card.// -->
                    <hr style="width: 80%; margin-left: 10%;"/>
                    <h5 style="margin-left: 10px;margin-top: 50px;"class="text text-center fw-bold">Compare Items</h5> 
                    <button style="width: 60%;margin-left: 20%;margin-bottom: 10px "class="btn btn-danger">Clear current item</button>
                    <div class="card">
                        <article class="card-group-item">
                            <header  style="background-color: #dfe6e9" class="card-header">
                                <h6 class="title fw-bold">Current item </h6>
                            </header>
                            <div class="filter-content">
                                <div class="card-body">
                                    <div class="form-row row container-fluid">
                                        <div class=" col-12 col-md-12 form-check">
                                            <h6>ID: </h6>
                                            <h6>Name: </h6>
                                            <h6>Agency: </h6>
                                            <h6>Origin:</h6>
                                        </div>
                                    </div>
                                </div> <!-- card-body.// -->
                            </div>
                        </article> <!-- card-group-item.// -->
                    </div>
                </div>
                <!--                Product-->
                <div class=" row col-md-9 col-sm-8">
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" style="padding: 10px;">
                        <div class="product">
                            <div class="product-img">
                                <img src="https://media.istockphoto.com/vectors/online-shop-logo-design-template-vector-id1150644423?k=20&m=1150644423&s=612x612&w=0&h=xKnuj3AhBbMAjxnJdT6Mh7o4BDIGaEwyol33tRwG7mU=" alt="">
                                <div class="product-label">
                                    <span class="new">Free ship</span>
                                    <span class="sold">Sold: 0</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                                <div class="product-rating">
                                    <i class="rate fas fa-star"></i> 
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star"></i>
                                    <i class="rate fas fa-star-half-alt"></i>
                                    <i class="rate far fa-star"></i>
                                    <span class="fw-bold text-danger">&nbsp(0)</span>
                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart"></i><span class="tooltipp">wishlist</span></button>
                                    <button class="add-to-compare"><i class="fas fa-exchange-alt"></i><span class="tooltipp"> compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- show-items -->
        <!-- Categories -->
        <div class="container-fluid pt-5">
            <h3 class="section-title position-relative mx-xl-5 mb-4"><span class="fw-bold text-uppercase text-danger m-1">Categories</span></h3>
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">
                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <a class="text-decoration-none" href="">
                        <div class="cat-item d-flex align-items-center mb-4">
                            <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                <img class="img-fluid" src="https://res.cloudinary.com/dec25/image/upload/v1658859832/ec14dd4fc238e676e43be2a911414d4d_tn_iw5jo7.png" alt="">

                            </div>
                            <div class="flex-fill pl-3">
                                <h6 class="text text-danger fw-bold">Category Name</h6>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <!-- Categories -->

    </div>
    <div class="footer">
        <footer>
            <div id="contact" class="allfoot row">
                <div class="col-md-4 col30">
                    <h4 class="text fw-bold text-uppercase text-danger">Contact With Us</h4>
                    <ul class="contact">
                        <li><i class="fa fa-university"></i> Ho Chi Minh City Open University</li>
                        <li><i class="fa fa-envelope"></i> ou.ecommerce.manager@gmail.com</li>
                        <li><i class="fa fa-phone"></i> (+084) 784301745</li>
                        <li><i class="fab fa-github"></i> https://github.com/thuvan2512</li>
                        <li><img class="img-fluid" style="margin-left:30%!important;"src="${logo}" width="20%" alt="logo"/></li>
                    </ul>
                </div>
                <div class="col-md-4 col30">
                    <h4  class="text fw-bold text-uppercase text-danger">Feedback</h4>
                    <input name="email" required placeholder=" Your email" required type="email" id="name-of-patient-comment">
                    <textarea name="content" required placeholder=" Content..." id="content-of-comment"></textarea>
                    <div class="star-comment">
                        <div id="rating">
                            <input type="radio" id="star5" name="rating" value="5" />
                            <label for="star5" title="Awesome - 5 stars"></label>

                            <input type="radio" id="star4" name="rating" value="4" />
                            <label for="star4" title="Pretty good - 4 stars"></label>

                            <input type="radio" id="star3" name="rating" value="3" />
                            <label for="star3" title="Medium - 3 stars"></label>

                            <input type="radio" id="star2" name="rating" value="2" />
                            <label for="star2" title="Bad - 2 stars"></label>

                            <input type="radio" id="star1" name="rating" value="1" />
                            <label for="star1" title="Very Bad - 1 star"></label>
                        </div>
                    </div>
                    <input type="submit" style="border:none" class="btn btn-danger" onclick="addComment()" id="button_comment" value="Send"/>

                </div>
                <div class="col-md-4 col50">
                    <h4  class="text fw-bold text-uppercase text-danger">e-commerce business</h4> 
                    <figure class="text-end">
                        <blockquote class="blockquote">
                            <p class="fst-italic"> Lorem ipsum dolor sit amet, consectetur adipiscing dolor sit amet selit, sed do eiusmod tempor
                                <br>  
                                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex 
                                incididunt ut labore et dolore magna aliqua.
                            </p>
                        </blockquote>
                        <figcaption class="blockquote-footer text-light">
                            <cite title="Source Title">Thu Nguyen Van - Founder of ouecommerce</cite>
                        </figcaption>
                    </figure>
                    <div class="fb">
                        <ul class="social" style="margin-left: 25%">
                            <li><a title="facebook" target="_blank"
                                   href="https://www.facebook.com/thunv2512"><img
                                        src="<c:url value="/images/logo/logofb.png"/>" alt="fblogo"/></a></li>
                            <li><a title="instagram" target="_blank" href="https://www.instagram.com/thunv.2512/"><img
                                        src="<c:url value="/images/logo/logoig.png"/>" alt="inslogo"/></a></li>
                            <li><a title="pinterest" target="_blank"
                                   href="https://www.pinterest.com/"><img
                                        src="<c:url value="/images/logo/logopt.png"/>"  alt="pinterestlogo"/></a></li>
                            <li><a title="github" target="_blank" href="https://github.com/thuvan2512"><img
                                        src="<c:url value="/images/logo/logogithub.png"/>"  alt="githublogo"/></a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</body>
</html>
