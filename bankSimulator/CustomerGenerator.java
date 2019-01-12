package bankSimulator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomerGenerator implements Runnable {
	
	CustomerLiner customerLiner;
	private static Random random = new Random(47);
	
	public CustomerGenerator(CustomerLiner customerLiner) {
		// TODO Auto-generated constructor stub
		this.customerLiner = customerLiner;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep((long) 0.00002);
				customerLiner.put(new Customer(random.nextInt(1000)));
			}			
		} catch(InterruptedException e) {
			System.out.println("CustomerGenerator interrupted");
		}
		System.out.println("CustomerGenerator terminating");
	}
}
