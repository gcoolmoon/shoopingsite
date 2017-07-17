package app.model;

import java.util.*;

public class ShoopingCart {

	 private List<Product> products ;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
	 public void addProduct(Product product) {
		 this.products.add(product);
	 }
	 
	 
}
