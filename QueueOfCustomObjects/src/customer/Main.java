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
		System.out.println("There are " + queue.size() + " customers in the queue");

		// Iterate through the customers in the queue in priority order. The customers are not removed from the queue
		for (Customer c: queue) {
			System.out.println("Loyalty ID = " + c.getLoyaltyID() + ", VIP Level = " + c.getVIPLevel());
		}
		System.out.println("There are " + queue.size() + " customers remaining in the queue");
		// Iterate through the customers in the queue in priority order AND remove them from the queue.
		try {
			while (true) {
				Customer c = queue.poll();	// The next person in line
				System.out.println("Loyalty ID = " + c.getLoyaltyID() + ", VIP Level = " + c.getVIPLevel());
			}
		} catch (Exception ex) {}	// Eat the exception
		
		System.out.println("There are " + queue.size() + " customers remaining in the queue");
	}
}
