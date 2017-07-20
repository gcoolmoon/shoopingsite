<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-left">

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
					<c:if test="${sessionScope.CurrentUser!=null}">
					<div> <c:out value="Welcome, ${sessionScope.CurrentUser.firstName}"></c:out>  </div>
					</c:if>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="logo">
					<h1>
						<a href="/mercato">Mercato</a>
					</h1>
				</div>
				<div class=" h_menu4">
					<ul class="memenu skyblue">
						<li><a class="color4" href="products">Products</a></li>
					 <c:if test="${sessionScope.CurrentUser==null}">
						<li><a class="color4" href="registration.jsp">Register</a></li>
						<li><a class="color4" href="login">Login</a></li>
						</c:if>
						 <c:if test="${sessionScope.CurrentUser!=null}">
						<li><a class="color4" href="orderhistory">Orders</a></li>
						</c:if>
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	
<div class=" container">
<div class=" register">
	
		  	  <form action="/order" method="post">
				 <div class="col-md-6 register-top-grid">
					<h3>Personal infomation</h3>
					 <div>
						<span>First Name</span>
						<input type="text" name="firstname"> 
					 </div>
					 <div>
						<span>Last Name</span>
						<input type="text" name="lastname"> 
					 </div>
					 <div>
						 <span>Email Address</span>
						 <input type="text" name ="email"> 
					
				     <div class="col-md-6 register-bottom-grid">
						    <h3>Login information</h3>
							 <div>
								<span>Password</span>
								<input type="password" name="password" id ="pass1" 
								pattern="^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\d).{6,}">
							 </div>
							 <div>
								<span>Confirm Password</span>
								<input type="password" name="password2" id="pass2" onblur="checkPass()">
                               <div><span id="confirmMessage" class="confirmMessage"></span> </div>  
							 </div>
							 <input type="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div>
				</form>
			</div>
</div>


</body>
</html>