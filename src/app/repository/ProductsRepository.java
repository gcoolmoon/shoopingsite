package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.model.Product;

public class ProductsRepository {
	
	public static List<Product> products = new ArrayList<>();
	
	public static List<Product> getProductsAvailable() {
		Product product = new Product(1, "Tomato", "Great big tomato", 30.14, 10, "/mercato/ui/images/pi5.jpg");
		Product product1 = new Product(2, "Potato", "Great big potato", 20.10, 10, "/mercato/ui/images/pi5.jpg");
		Product product2 = new Product(3, "Onion", "Great big Onion", 15.00, 10, "/mercato/ui/images/pi5.jpg");
		Product product3 = new Product(4, "Garlic", "Great big garlic", 38.40, 10, "/mercato/ui/images/pi5.jpg");
		Product product4 = new Product(5, "Pizza", "Great big pizza", 50.00, 10, "/mercato/ui/images/pi5.jpg");
		Product product5 = new Product(6, "Chiken", "Great big chiken", 10.15, 10, "/mercato/ui/images/pi5.jpg");
		Product product6 = new Product(7, "Fish", "Great big fish", 12.20, 10, "/mercato/ui/images/pi5.jpg");
		products.add(product);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		
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
	
	public static Product getProduct(int id) {
		return products.stream().filter(item -> item.getProductId() == id).findFirst().get();
	}

}
