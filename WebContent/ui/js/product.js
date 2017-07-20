$(function(){
	
	
	
	
	
	
	$(init);


function init() {
	setListeners();
	console.log("hey");
}

function setListeners() {
	$(".add_product").click(addProduct);
}
function addProduct(){
	$.post('product',{name:$('#product_name').val(), price:$('#product_price').val()}, processData)
}


function processData(data){
	data = JSON.parse(data);

	var td0=$('<td>').text(data.id);
	var td1 = $('<td>').text(data.name);
	var td2 = $('<td>').text(data.price);
	var tr = $('<tr>').append(td0).append(td1).append(td2);
	$('#tbl_products>tbody').append(tr);
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
})