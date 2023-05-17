<!-- include footer -->
<jsp:include page="/includes/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- include footer -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-4">
	<div class="header-right">
		<ul class="list-unstyled list-inline">
			<li class="dropdown dropdown-small"><a data-toggle="dropdown"
				data-hover="dropdown" class="dropdown-toggle" href="#"><span
					class="key">Category</span><b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/product">Clear</a></li>
				<c:forEach items="${categories}" var="category">
					<li><a href="/product?category=${category.name}">${category.name}</a></li>
				</c:forEach>
				</ul></li>
		</ul>
	</div>
</div>

<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-md-3 col-sm-6">
				<div class="single-shop-product">
					<div class="product-upper">
						<img src="${product.image}" alt="">
					</div>
					<h2>
						<a href="">${product.name}</a>
					</h2>
					<div class="product-carousel-price">
						<ins>${product.price}VND</ins>
					</div>

					<div class="product-option-shop">
						<a class="add_to_cart_button" data-quantity="1"
							data-product_sku="" data-product_id="70" rel="nofollow"
							href="#">Add to cart</a>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="product-pagination text-center">
					<nav>
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/includes/footer.jsp" />