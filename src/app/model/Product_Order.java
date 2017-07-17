package app.model;

public class Product_Order {
	private int productOrderId;
	private int productId;
	private int orderId;
	private int amount;
	
	
	public int getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}
	public int getProductId() {
		return productId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	} 
	
	
}
