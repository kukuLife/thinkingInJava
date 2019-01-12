package bankSimulator;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankSimulation {
	
	
	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSTMEN_PEROID = 1000;
	
	
	public static void main(String[] args) throws IOException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		CustomerLiner customers = new CustomerLiner(MAX_LINE_SIZE);
		
		executor.execute(new CustomerGenerator(customers));
		executor.execute(new TellerManager(executor, customers, ADJUSTMEN_PEROID));
		
		System.out.println("press Enter to quit");
		System.in.read();
		
		executor.shutdown();
		
	}

}
