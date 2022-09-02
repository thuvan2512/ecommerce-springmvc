<%-- 
    Document   : revenue-stats
    Created on : 23 Aug 2022, 19:40:41
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row col-md-12 col-12 mb-5">
    <p class="text-center h1 fw-bold mb-3 mx-1 mx-md-4 mt-4 text-uppercase">Revenue Statistics</p>
    <div class="col-12 col-md-12 row">
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Revenue Statistics By Month - ${yearStats}</p>
            <div class="col-md-4 col-4 mt-5">
                <form>
                    <div class="mb-2 form-group">
                        <input id="input-revenue-stats" placeholder="Enter a year" name="year" type="number" step="1" min="2021" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');"/>
                    </div>
                    <div class=" form-group">
                        <button type="submit" class="btn btn-outline-dark">Enter</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-7 col-md-7">
            <canvas id="chart-stats-revenue-month" width="400" height="400"></canvas>
        </div>
        <div class="col-5 col-md-5">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Month</th>
                        <th scope="col">Total Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${revenueStatsMonth}" var="revenue" varStatus="loops">
                        <tr>
                            <th>${labelsMonth[loops.index]}</th>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${revenue[1]}"/> VND</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-12 col-md-12 row">
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Revenue Statistics By Quarter - ${yearStats}</p>
            <div class="col-md-4 col-4 mt-5">
                <form>
                    <div class="mb-2 form-group">
                        <input id="input-year-revenue-stats" placeholder="Enter a year" name="year" type="number" step="1" min="2021" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1');"/>
                    </div>
                    <div class=" form-group">
                        <button type="submit" class="btn btn-outline-dark">Enter</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-5 col-md-5">
            <canvas id="chart-stats-revenue-quarter" width="400" height="400"></canvas>
        </div>
        <div class="col-7 col-md-7">
                        <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Quarter</th>
                        <th scope="col">Total Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${revenueStatsQuarter}" var="revenue" varStatus="loops">
                        <tr>
                            <th>${labelsQuarter[loops.index]}</th>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${revenue[1]}"/> VND</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
        <div class="col-12 col-md-12 row">
        <div class="container py-5">
            <p class="text-center h4 fw-bold mb-2 mx-1 mx-md-4 mt-2 text-uppercase">Revenue Statistics By Year</p>
        </div>
        <div class="col-5 col-md-5">
            <canvas id="chart-stats-revenue-year" width="400" height="400"></canvas>
        </div>
        <div class="col-7 col-md-7">
                        <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Year</th>
                        <th scope="col">Total Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${revenueStatsYear}" var="revenue" varStatus="loops">
                        <tr>
                            <th>${revenue[0]}</th>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${revenue[1]}"/> VND</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    window.onload = function () {
        var dataStatsMonth = [];
        var dataStatsQuarter = [];
        var dataStatsYear = [];
        var labelStatsYear = [];
    <c:forEach items="${revenueStatsMonth}" var="rsmonth">
        dataStatsMonth.push(${rsmonth[1]});
    </c:forEach>
    <c:forEach items="${revenueStatsQuarter}" var="rsquarter">
        dataStatsQuarter.push(${rsquarter[1]});
    </c:forEach>
    <c:forEach items="${revenueStatsYear}" var="rsyear">
        dataStatsYear.push(${rsyear[1]});
        labelStatsYear.push(${rsyear[0]});
    </c:forEach>
        loadChartRevenueStatsMonth(dataStatsMonth, ${yearStats});
        loadChartRevenueStatsQuarter(dataStatsQuarter, ${yearStats});
        loadChartRevenueStatsYear(labelStatsYear,dataStatsYear)
    };
</script>
