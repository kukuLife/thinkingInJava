package bankSimulator;

public class Customer {
	
	private final int serveTime;
	
	public Customer(int st) {
		this.serveTime = st;
	}
	
	public int getServeTime() {
		return this.serveTime;
	}
	
	public String toString() {
		return "customer serve" + this.serveTime;
	}

}
