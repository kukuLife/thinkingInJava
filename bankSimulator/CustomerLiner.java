package bankSimulator;

import java.util.concurrent.ArrayBlockingQueue;

public class CustomerLiner extends ArrayBlockingQueue<Customer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerLiner(int maxLineSize) {
		super(maxLineSize);
	}

	public String toString() {
		if(this.size() == 0) return "empty";
			StringBuilder result = new StringBuilder();
			for(Customer customer : this) {
				result.append(customer);
			}
			return result.toString();		

	}
	
}
