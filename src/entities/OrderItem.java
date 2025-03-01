package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity,  Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.price = this.subTotal();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return getProduct().getPrice() * quantity;
	}
	
}
