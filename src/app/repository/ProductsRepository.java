package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.model.Product;

public class ProductsRepository {

	public static List<Product> products = new ArrayList<>();
	public static void addProducts() {
		
	}
	public static List<Product> getProductsAvailable() {
	
		
		return products;
		
	}
   public static void addProduct(int id, String name, String description, double price, int amount, String url) {
	   Product product = new Product(id, name, description, price, amount, url);
	   products.add(product);
   }
   public static void addProduct(Product product) {
	   products.add(product);
   }
   public static void updateProduct(int productId, int amount) {
	   for (Product product : products) {
		   if(product.getProductId() == productId)
		   {
			   product.setAmountAvailable(product.getAmountAvailable() + amount);
		   }
		   }
   }
   public static Product getProduct(int productId) {
	   return products.stream().filter(a->a.getProductId() == productId).findFirst().get() ;
   }
}
