package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment = new Date();
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double total = 0.0;
		for (OrderItem orderItem : items) {
			total += orderItem.subTotal();
		}
		return total;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (OrderItem orderItem : items) {
			sb.append(orderItem.getProduct().getName());
			sb.append(", ");
			sb.append(orderItem.getProduct().getPrice());
			sb.append(", ");
			sb.append(" Quantity: " + orderItem.getQuantity());
			sb.append(", ");
			sb.append(" Subtotal: " + orderItem.subTotal());
			sb.append(", \n");
		}
		sb.append("Total Price: " + this.total());
		
		return sb.toString();
		
	}
	
	
	
}
