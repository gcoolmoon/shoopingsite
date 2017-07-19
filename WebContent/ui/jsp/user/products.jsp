<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mercato</title>
<link href="ui/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="ui/js/jquery.min.js"></script>
<link href="ui/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<link href="ui/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="ui/js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="ui/js/simpleCart.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-left">

					<div class="search-box">
						<div id="sb-search" class="sb-search">
							<form action="#" method="post">
								<input class="sb-search-input"
									placeholder="Enter your search term..." type="search"
									id="search"> <input class="sb-search-submit"
									type="submit" value=""> <span class="sb-icon-search">
								</span>
							</form>
						</div>
					</div>

					<!-- search-scripts -->
					<script src="ui/js/classie.js"></script>
					<script src="ui/js/uisearch.js"></script>
					<script>
						new UISearch(document.getElementById('sb-search'));
					</script>
					<!-- //search-scripts -->

					<div class="ca-r">
						<div class="cart box_1">
							<a href="checkout.html">
								<h3>
									<div class="total">
										<span class="simpleCart_total"></span>
									</div>
									<img src="ui/images/cart.png" alt="" />
								</h3>
							</a>
							<p>
								<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
							</p>

						</div>
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="logo">
					<h1>
						<a href="index.html">Mercato</a>
					</h1>
				</div>
				<div class=" h_menu4">
					<ul class="memenu skyblue">
						<li><a class="color4" href="registration.jsp">Register</a></li>
						<li><a class="color4" href="login">Login</a></li>
						<li><a class="color6" href="contact.html">Contact</a></li>
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- products -->
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>Products</h2>
		</div>
	</div>
	<!-- grow -->
	<div class="pro-du">
		<div class="container">
			<div class="col-md-9 product1">
				<div class=" bottom-product">
					<!-- For each -->
					<c:forEach items="${products}" var="product">
						<div class="col-md-6 bottom-cd simpleCart_shelfItem">
							<div class="product-at ">
								<a href="single.html"><img class="img-responsive"
									src="${product.image}" alt="">
									<div class="pro-grid">
										<span class="buy-in">Buy Now</span>
									</div> </a>
							</div>
							<p class="tun">
								<span>${product.productDescription}</span><br>${product.productName}
							</p>
							<div class="ca-rt">
								<a href="#" class="item_add"><p class="number item_price">
										<i> </i>$${product.price}
									</p></a>
							</div>
							<div class="clearfix"></div>
						</div>
					</c:forEach>

				</div>
				<!-- End for each -->
		</div>
	</div>
	</div>
	<!-- products -->
</body>
</html>