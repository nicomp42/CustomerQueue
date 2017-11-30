package customer;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Customer> queue = new PriorityQueue<Customer>();

		// Add some customers
		queue.add(new Customer(12345, 0));
		queue.add(new Customer(123456, 100));		// An exception here: Exception in thread "main" java.lang.ClassCastException: customer.Customer cannot be cast to java.lang.Comparable
		queue.add(new Customer(99999, 99));
		queue.add(new Customer(11111, 1));
		queue.add(new Customer(11112, 98));
		queue.add(new Customer(22233, 2));

		// Iterate through the customers in the queue in physical order. Not prioritized!
		for (Customer c: queue) {
			System.out.println("Loyalty ID = " + c.getLoyaltyID() + ", VIP Level = " + c.getVIPLevel());
		}
		// Iterate through the customers in the queue in physical order. Not prioritized!
		try {
			while (true) {
				Customer c = queue.poll();	// The next person in line
				System.out.println("Loyalty ID = " + c.getLoyaltyID() + ", VIP Level = " + c.getVIPLevel());
			}
		} catch (Exception ex) {}	// Eat the exception
	}
}
