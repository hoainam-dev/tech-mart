<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="model.*" %>
<%@page import="dao.*" %>
<%@page import="connectdb.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.text.DecimalFormat"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
    	ProductDAO pDao = new ProductDAO();
        cartProduct = pDao.getCartProducts(cart_list);
        double total = pDao.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_list", cart_list);
    }
%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/includes/head.jsp" />
</head>
<body>
	<div class="slider-area">
		<!-- Slider -->
		<div class="block-slider block-slider4">
			<ul class="" id="bxslider-home4">
				<li><img src="static/img/h4-slide.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							iPhone <span class="primary">6 <strong>Plus</strong></span>
						</h2>
						<h4 class="caption subtitle">Dual SIM</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="static/img/h4-slide2.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							by one, get one <span class="primary">50% <strong>off</strong></span>
						</h2>
						<h4 class="caption subtitle">school supplies & backpacks.*</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="static/img/h4-slide3.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Apple <span class="primary">Store <strong>Ipod</strong></span>
						</h2>
						<h4 class="caption subtitle">Select Item</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>
				<li><img src="static/img/h4-slide4.png" alt="Slide">
					<div class="caption-group">
						<h2 class="caption title">
							Apple <span class="primary">Store <strong>Ipod</strong></span>
						</h2>
						<h4 class="caption subtitle">& Phone</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>
			</ul>
		</div>
		<!-- ./Slider -->
	</div>
	<!-- End slider area -->