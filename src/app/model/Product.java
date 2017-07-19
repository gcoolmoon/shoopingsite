package app.model;

public class Product {

	private int productId;
	private String productName;
	private String productDescription;
	private Double price;
	private String image;
	private int amountAvailable;
	private String image;
	
	
	public Product(int productId, String productName, String productDescription, Double price, int amountAvailable, String image) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.amountAvailable = amountAvailable;
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getPicture() {
		return image;
	}
	public void setPicture(String picture) {
		this.image = picture;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String prodcutDescription) {
		this.productDescription = prodcutDescription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAmountAvailable() {
		return amountAvailable;
	}
	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}
	
	
}
