<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/includes/head.jsp" />
</head>
<body>
<c:set value="${sessuser}" var="user"/>
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<c:choose>
								<c:when test="${user==null}">
									<li><a href="/login"><i class="fa fa-user"></i> Login</a></li>
  								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test='${user=="admin@gmail.com"}'>
											<li><a href="/admin"><i class="fa fa-user"></i>Admin DardBoard</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/cart"><i class="fa fa-user"></i> My Cart</a></li>
											<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
											<li><a href="#"><i class="fa fa-user"></i>Checkout</a></li>
										</c:otherwise>
									</c:choose>
									<li><a href="#"><i class="fa fa-user"></i><%=session.getAttribute("sessuser")%></a></li>
									<li><a href="logout">Logout</a></li>
  								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="./">TechMart Shop</a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="cart.html">Cart - <span class="cart-amunt">$100</span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/">Home</a></li>
						<li><a href="/product">Shop page</a></li>
						<li><a href="#">Others</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->