package bankSimulator;

import java.util.concurrent.TimeUnit;

public class Teller implements Runnable, Comparable<Teller> {
	
	CustomerLiner customerLiner;
	
	public boolean servingCustomerLine = true;
	
	private static int count;
	
	private final int id = count++;
	
	private int customerServed = 0;
	
	public Teller(CustomerLiner customerLiner) {
		this.customerLiner = customerLiner;
	}
	
	

	@Override
	public synchronized int compareTo(Teller o) {
		return this.customerServed < o.customerServed ? -1 : (this.customerServed == o.customerServed ? 0:1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub		
		while(!Thread.interrupted()) {
			
			try {
				Customer customer = this.customerLiner.take();
				TimeUnit.MICROSECONDS.sleep(customer.getServeTime());
				synchronized (this) {
					this.customerServed ++;
					if(!this.servingCustomerLine) {
						wait();
					}
				}

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(this + "interrupted");
			}	
		}
		System.out.println(this + "terminating");
	}
	
	
	public synchronized void doSomeThingElse() {
		this.customerServed = 0;
		this.servingCustomerLine = false;
	}
	
	public synchronized void servingCustomer() {
		assert !servingCustomerLine:"already serving:" + this;
		this.servingCustomerLine = true;
		notifyAll();
	}
	
	public String toString() {
		return "Teller" + this.id;
	}


}
