<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<div class=" container">
<div class=" register">
	
		  	  <form action="/adminproducts" method="post">
				 <div class="col-md-6 register-top-grid">
					<h3>Product Information</h3>
					 <div>
						<span>Product Id</span>
						<input type="text" name="productid"> 
					 </div>
					 
  					<input type="hidden" name="crudaction" value="update">
					 <div>
						<span>Additional Amount</span>
						<input type="number" name="amount"> 
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