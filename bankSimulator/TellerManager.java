package bankSimulator;

import java.sql.Time;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TellerManager implements Runnable {
	
	private ExecutorService exec;
	private CustomerLiner customers;
	
	private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
	
	private Queue<Teller> dosomethingElseTellers = new LinkedList<Teller>(); {
	};
	
	private int ajustmentPeriod;
	
	
	
	public TellerManager(ExecutorService exec, CustomerLiner cutomers, int ajustTime) {
		this.exec = exec;
		this.customers = cutomers;
		this.ajustmentPeriod = ajustTime;
		Teller teller = new Teller(customers);
		exec.execute(teller);
		workingTellers.add(teller);
		
	}
	
	
	public void ajustTellerNumber() {
		if(customers.size() / workingTellers.size() > 2) {
			if(dosomethingElseTellers.size() > 0) {
				Teller teller = dosomethingElseTellers.remove();
				teller.servingCustomer();
				workingTellers.add(teller);
				return;
			}			
			Teller teller = new Teller(customers);
			teller.servingCustomer();
			this.workingTellers.add(teller);

			return;
		}
		
		
		if(workingTellers.size() > 1 && (customers.size() / workingTellers.size() > 2)) {
			
			releaseWorkingTeller();
			
			if(customers.size() == 0) {
				while(workingTellers.size() > 1) {
					releaseWorkingTeller();
				}
			} 
			
		}
		
		
		
		
		
	}
	
	
	private void releaseWorkingTeller() {
		// TODO Auto-generated method stub
		if(workingTellers.size() > 0) {
			Teller teller = workingTellers.poll();
			teller.doSomeThingElse();
			this.dosomethingElseTellers.offer(teller);
		}
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(ajustmentPeriod);
				ajustTellerNumber();
				System.out.println(customers + "{");
				
				for(Teller teller:this.workingTellers) {
					System.out.println(teller);
				}
				
				System.out.println("}");
			}
			
			
		} catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println(this + "interrupted");
		}
		
		System.out.println(this + "terminated");
		
	}
	
	
	public String toString() {
		return "tellerManager";
	}
	
	
	
	
}
