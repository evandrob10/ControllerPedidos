package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entites.Client;
import Entites.Order;
import Entites.OrderItem;
import Entites.Product;
import Entites.enums.OrderStatus;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner x  = new Scanner(System.in);
		System.out.println("Enter cliente data: ");
		
		System.out.print("Name: ");
		String name = x.nextLine();
		
		System.out.print("Email: ");
		String email = x.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate bithDate = LocalDate.now();
		
		Client client = new Client(name,email, LocalDate.parse(x.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("Enter Order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(x.nextLine());
		
		Order pedido = new Order(status,client);
		
		System.out.println("How many items to this order? ");
		Integer quantity = x.nextInt();
	
		for(int i = 1; i <= quantity; i++){
			x.nextLine();
			System.out.printf("Enter #%d item data:\n",i);
			
			System.out.printf("Product name: ");
			String nameProduct = x.nextLine();
			
			System.out.printf("Product price: ");
			Double priceProduct = x.nextDouble();
			
			System.out.printf("Quantity: ");
			Integer quantityProduct = x.nextInt();
			
			pedido.addItems(new OrderItem(quantityProduct,priceProduct,new Product(nameProduct,priceProduct)));
		}
		
		System.out.println(pedido.toString());
		
		x.close();
	}
}
