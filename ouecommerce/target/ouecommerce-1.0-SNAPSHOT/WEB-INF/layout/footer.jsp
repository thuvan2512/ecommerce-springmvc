<%-- 
    Document   : footer
    Created on : 3 Aug 2022, 15:36:18
    Author     : thu.nv2512
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="about-us"class="footer">
    <footer>
        <div id="contact" class="allfoot row">
            <div class="col-md-4 col30">
                <h4 style="color:white" class="text fw-bold text-uppercase"> <spring:message code="label.footer.contact"/></h4>
                <ul class="contact">
                    <li><i class="fa fa-university"></i> Ho Chi Minh City Open University</li>
                    <li><i class="fa fa-envelope"></i> ou.ecommerce.manager@gmail.com</li>
                    <li><i class="fa fa-phone"></i> (+084) 784301745</li>
                    <li><i class="fab fa-github"></i> https://github.com/thuvan2512</li>
                    <li><img class="img-fluid" style="margin-left: 10%;margin-top: 10px;"src="<c:url value="/images/logo/logobanner.png"/>" width="60%" alt="logo"/></li>
                </ul>
            </div>
            <div class="col-md-4 col30">
                <h4 style="color:white" class="text fw-bold text-uppercase "><spring:message code="label.footer.feedback"/></h4>
                <input name="email" required placeholder=" <spring:message code="label.footer.feedback.yourEmail"/>" required type="email" id="name-of-patient-comment">
                <textarea name="content" required placeholder=" <spring:message code="label.footer.feedback.content"/>" id="content-of-comment"></textarea>
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
                <input type="submit" style="border:none" class="btn btn-danger" onclick="addComment()" id="button_comment" value="<spring:message code="label.footer.feedback.send"/>"/>

            </div>
            <div class="col-md-4 col50">
                <h4 style="color:white" class="text fw-bold text-uppercase">e-commerce business</h4> 
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
