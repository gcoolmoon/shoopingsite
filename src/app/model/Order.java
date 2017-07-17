package app.model;
import java.util.*;

public class Order {
       private int orderId;
       private List<Product_Order> productsOrders;
       private Date orderDate;
       
       
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product_Order> getProductsOrder() {
		return productsOrders;
	}
	public void setProductsOrder(List<Product_Order> productsOrders) {
		this.productsOrders = productsOrders;
	}
       public void addProduct(Product_Order productOrder) {
    	   this.productsOrders.add(productOrder);
       }
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
       
       
}
