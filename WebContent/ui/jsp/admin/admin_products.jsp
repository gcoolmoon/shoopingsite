<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Products</title>
<link href="../../css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="../../js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="../../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<link href="../../css/memenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../../js/memenu.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="../../js/simpleCart.min.js">
	
</script>
</head>
<body>


<div class=" container">
<div class=" register">
	
		  	  <form action="/adminproducts" method="post">
				 <div class="col-md-6 register-top-grid">
					<h3>Product Information</h3>
					
  					<input type="hidden" name="crudaction" value="add">
					 <div>
						<span>Product Id</span>
						<input type="text" name="productid"> 
					 </div>
					 <div>
						<span>Product</span>
						<input type="text" name="productname"> 
					 </div> 
					 <div>
						<span>Price</span>
						<input type="number" name="price"> 
					 </div>
					 <div>
						<span>Available Amount</span>
						<input type="number" name="amount"> 
					 </div>
					 <div>
						 <span>Image :</span>
						 <input type="file" name ="image"> </div>
					 <div>
						<span>  Product Description</span>
						<textarea cols="100" rows="10" name="productdesc"> </textarea>
					 </div>
					 
				     <div class="col-md-6 register-bottom-grid">

							 <input type="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div>
				</form>
			</div>
</div>

</body>
</html>