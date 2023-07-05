package Entites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Entites.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	List <OrderItem> items = new ArrayList<>();
	
	public Order() {}
	
	public Order(OrderStatus status, Client client) {
		this.moment = LocalDateTime.now();
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}

	public void removeItems(OrderItem item) {
		items.remove(item);
	}
	
	public String toString() {
		StringBuilder order = new StringBuilder();
		order.append("\n");
		order.append("ORDER SUMMARY:\n");
		order.append("Order moment: " + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		order.append("Order statud: " + this.status + "\n");
		order.append("Client: " + client.getName() + " " + String.format(("%d/%d/%d"), client.getBithDate().getDayOfMonth(),client.getBithDate().getMonthValue(),client.getBithDate().getYear()) + " - " + client.getEmail() + "\n");
		order.append("Order items:\n");
		Double valueTotal = 0.00;
		for(OrderItem item : this.items) {
			order.append(item.getProduct().getName() + ",");
			order.append(" $" + item.getPrice() + ",");
			order.append(" Quantity: " + item.getQuantity() + ",");
			order.append(" Subtotal: " + item.subTotal() + "\n");
			valueTotal += item.subTotal();
		}
		order.append("Total price: " + valueTotal);
		return order.toString();
	}
	
}
