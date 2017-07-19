package app.model;
import java.util.*;

public class Order {
       private int orderId;
       private List<ProductOrder> productsOrders;
       private Date orderDate;
       
       
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<ProductOrder> getProductsOrder() {
		return productsOrders;
	}
	public void setProductsOrder(List<ProductOrder> productsOrders) {
		this.productsOrders = productsOrders;
	}
       public void addProduct(ProductOrder productOrder) {
    	   this.productsOrders.add(productOrder);
       }
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
       
       
}
