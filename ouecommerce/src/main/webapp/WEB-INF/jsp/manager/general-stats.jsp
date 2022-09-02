<%-- 
    Document   : revenue-stats
    Created on : 23 Aug 2022, 19:40:41
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row col-md-12 col-12 mb-5">
    <div class="container py-5">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">General Statistics</p>
    </div>
    <div class="col-12 col-md-12 row">
        <div class="col-8 col-md-8 main-content">
            <div class="d-flex my-4 flex-wrap">
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763545/gallery_pz27ed.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Sale Post</div>
                        <div class="ms-auto number">${countProducts}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763749/trolley_m6emlm.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Orders placed</div>
                        <div class="ms-auto number">${listOrderDetail.size()}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661752602/online-shopping_wqanzo.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Quantity Sold</div>
                        <div class="ms-auto number">${countSold}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661752526/1244038_xgdn2l.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Like(s)</div>
                        <div class="ms-auto number">${countLike}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661763545/comment_puc6r3.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Comment(s)</div>
                        <div class="ms-auto number">${countComment}</div>
                    </div>
                </div>
                <div class="box me-4 my-1 bg-light">
                    <img src="https://res.cloudinary.com/dec25/image/upload/v1661767185/police-badge_f35ei8.png"
                         alt="">
                    <div class="d-flex align-items-center mt-2">
                        <div class="tag">Average star</div>
                        <div class="ms-auto number"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${avgStar}" /></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-4">
            <img src="https://res.cloudinary.com/dec25/image/upload/v1661238920/Usability_testing-pana_zyjjh5.png"
                 class="img-fluid" alt="Sample image">

        </div>

    </div>
    <div class="col-12 col-md-12 row">  
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Top Seller</p>
        </div>
        <div class="col-12 col-md-12 row">
            <div class="col-4 col-md-4">
                <form>
                    <div class="mb-2 form-group">
                        <select name="top" id="top-seller"class="form-select">
                            <option selected value="10"> Choose a value</option>
                            <option value="1">Top 1</option>
                            <option value="3">Top 3</option>
                            <option value="5">Top 5</option>
                            <option value="10">Top 10</option>
                        </select>
                    </div>
                    <div class="mb-2 form-group">
                        <button type="submit" class="btn btn-outline-dark">Enter</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-6 col-md-6">
            <canvas id="chart-top-seller" width="400" height="400"></canvas>
        </div>
        <div class="col-6 col-md-6">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Top</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Sold</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${topSeller}" var="item" varStatus="loops">
                        <tr>
                            <th scope="row">${loops.index + 1}</th>
                            <td>${item[2]}</td>
                            <td>${item[5]}</td>
                            <td>${item[4]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-12 col-md-12 row">
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Statistics by product category</p>
        </div>
        <div class="col-6 col-md-6">
            <canvas id="chart-stats-by-category" width="400" height="400"></canvas>
        </div>
        <div class="col-6 col-md-6">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Category</th>
                        <th scope="col">Quantity of sale post</th>
                        <th scope="col">Ratio (%)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${statsByCategory}" var="cate" varStatus="loops">
                        <tr>
                            <th scope="row">${loops.index + 1}</th>
                            <td>${cate[0]}</td>
                            <td class="text-center">${cate[1]}</td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(cate[1]/countProducts)*100}" /> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        window.onload = function () {
            var labelTopSeller = [];
            var dataTopSeller = [];
            var labelStatsCate = [];
            var dataStatsCate = [];
        <c:forEach items="${topSeller}" var="item">
            labelTopSeller.push(`${item[2]}-${item[5]}`);
                    dataTopSeller.push(${item[4]});
        </c:forEach>
        <c:forEach items="${statsByCategory}" var="cate">
                    labelStatsCate.push(`${cate[0]}`);
                    dataStatsCate.push(${cate[1]});
        </c:forEach>

                    loadChartTopSeller(labelTopSeller, dataTopSeller);
                    loadChartStatsCategory(labelStatsCate, dataStatsCate);
                };
    </script>
