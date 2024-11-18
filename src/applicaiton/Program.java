package applicaiton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY)");
		Date data = sdf.parse(sc.next());
		System.out.println("Choise a order data:"
				+ "\n - PENDING_PAYMENT"
				+ "\n - PROCESSING"
				+ "\n - SHIPPED"
				+ "\n - DELIVERED");
		
		String orderData = sc.next();
		
		Client client = new Client(name,email,data); 
		Order order = new Order(OrderStatus.valueOf(orderData));
		
		System.out.println("How many items to this order?");
		int items = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= items; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.println("Product name:");
			String nameProduct = sc.nextLine();
			System.out.println("Product price:");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity, new Product(nameProduct, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order statud: " + order.getStatus());
		System.out.println("Client: " + client.toString());
		System.out.println("Order items:" + "\n" + order.toString());
		
		sc.close();
		
	}
}
