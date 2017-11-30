package customer;

import java.util.ArrayList;
/**
 * A customer waiting to check out
 * @author nicomp
 *
 */
public class Customer implements Comparable<Object> {
	private ArrayList<String> items;
	private int loyaltyID;
	private int VIPLevel;		// How important is this customer? 0 = not, 100 = most

	/**
	 * Constructor
	 * @param loyaltyID Loyalty ID
	 * @param VIPLevel VIP Level 0 = none, 100 = highest
	 */
	public Customer (int loyaltyID, int VIPLevel) {
		items = new ArrayList<String>();
		setLoyaltyID(loyaltyID);
		setVIPLevel(VIPLevel);
	}
	public int getLoyaltyID() {return loyaltyID;}
	public void setLoyaltyID(int loyaltyID) {this.loyaltyID = loyaltyID;}
	public int getVIPLevel() {return VIPLevel;}
	public void setVIPLevel(int vIPLevel) {	VIPLevel = vIPLevel;}

	@Override
	/**
	 * The Comparable method needed by a Priority Queue class.
	 */
	public int compareTo(Object arg0) {
		int result = 0;
		int VIPLevel1, VIPLevel2;
		VIPLevel1 = this.getVIPLevel();
		VIPLevel2 = ((Customer)arg0).getVIPLevel();
//		System.out.println("Customer.compareTo(): comparing VIP Level " + this.getVIPLevel() + " with " + ((Customer)arg0).getVIPLevel());
		// We can invert the sort order by flipping the relational operator
		if (VIPLevel1 > VIPLevel2) {
			result = -1;
		} else {
			result = 1;
		}
//		System.out.println("Returning " + result);
		return result;
	}
	/**
	 * Generate a printable representation of the object.
	 * It would be nice to include the list of items being purchased.
	 */
	public String toString() {
		return loyaltyID + ": " + VIPLevel;
	}
}
