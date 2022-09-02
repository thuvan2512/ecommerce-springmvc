<%-- 
    Document   : general-stats
    Created on : 1 Sep 2022, 22:12:17
    Author     : thu.nv2512
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row col-md-12 col-12 mb-5">
    <div class="container py-5">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-uppercase">General Admin Statistics</p>
    </div>
    <div class="col-12 col-md-12 row">  
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Sale Frequency</p>
        </div>
        <div class="col-12 col-md-12 row">
            <div class="col-4 col-md-4">
                <form>
                    <div class="form-outline flex-fill mb-2">
                        <select name="topAgency" id="top-seller"class="form-select">
                            <option selected value="10"> Choose a value</option>
                            <option value="1">Top 1</option>
                            <option value="3">Top 3</option>
                            <option value="5">Top 5</option>
                            <option value="10">Top 10</option>
                        </select>
                    </div>
                    <div class="form-outline flex-fill mb-2">
                        <input class="form-select" placeholder="Enter a year" name="year" type="number" step="1" min="2021" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');"/>
                    </div>
                    <div class="form-outline flex-fill mb-2">
                        <select name="quarter" id="top-seller"class="form-select">
                            <option selected value="1"> Choose a quarter</option>
                            <option value="1">Quarter 1st</option>
                            <option value="2">Quarter 2nd</option>
                            <option value="3">Quarter 3rd</option>
                            <option value="4">Quarter 4th</option>
                        </select>
                    </div>
                    <div class="mb-2 form-group">
                        <button type="submit" class="btn btn-outline-dark">Enter</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-6 col-md-6">
            <canvas id="chart-stats-by-sale-frequency" width="400" height="400"></canvas>
        </div>
        <div class="col-6 col-md-6">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Top</th>
                        <th scope="col">Agency</th>
                        <th scope="col">Sold</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${saleFrequency}" var="sf" varStatus="loops">
                        <tr>
                            <th scope="row">${loops.index + 1}</th>
                            <td>${sf[0]}</td>
                            <td>${sf[1]}</td>
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
            <canvas id="chart-stats-by-category-admin-stats" width="400" height="400"></canvas>
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
    
        <div class="col-12 col-md-12 row">  
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Best Seller In The Whole System</p>
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
            <canvas id="chart-top-seller-admin-stats" width="400" height="400"></canvas>
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
    <script>
        window.onload = function () {
            var labelTopSeller = [];
            var dataTopSeller = [];
            var labelStatsCate = [];
            var dataStatsCate = [];
            var labelStatsSaleFrequency = [];
            var dataStatsSaleFrequency = [];
        <c:forEach items="${topSeller}" var="item">
            labelTopSeller.push(`${item[2]}-${item[5]}`);
                    dataTopSeller.push(${item[4]});
        </c:forEach>
        <c:forEach items="${statsByCategory}" var="cate">
                    labelStatsCate.push(`${cate[0]}`);
                    dataStatsCate.push(${cate[1]});
        </c:forEach>
        <c:forEach items="${saleFrequency}" var="sf">
                    labelStatsSaleFrequency.push(`${sf[0]}`);
                    dataStatsSaleFrequency.push(${sf[1]});
        </c:forEach>

                    loadChartTopSellerInAdminStats(labelTopSeller, dataTopSeller);
                    loadChartStatsCategoryInAdminStats(labelStatsCate, dataStatsCate);
                    loadChartStatsSalesFrequency(labelStatsSaleFrequency,dataStatsSaleFrequency);
                };
    </script>
