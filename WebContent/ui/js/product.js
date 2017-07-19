$(init);

function init() {
	setListeners();
	console.log("hey");
}

function setListeners() {
	$(".add_product").click(addProduct);
}

function addProduct() {
	var products = sessionStorage.getItem("products");
	var product = $("#product").val();
	console.log(product);
	var hey = product.getPrice();
	if(products !== null){
		products.push(product);
	} else {
		products = new Array();
		products.push(product);
		products.push(product);
	}
	sessionStorage.setItem("products", JSON.stringify(products));
	updateTotal(products);
}

function updateTotal(products) {
	var totalAmount = 0.0;
	for (var i = 0; i < products.length; i++) {
		var test = products[i].price;
		totalAmount = totalAmount + test;
	}
	$("total_amount").text(totalAmount);
}