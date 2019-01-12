package customerConsumer;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	
	Resterant resterant;
	private int count = 0;
	
	public Chef(Resterant r) {
		this.resterant = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted()) {
			try{

				synchronized (this) {
					if(resterant.meal != null) {
						wait();
					} 
				}
				
				if(++ count == 10) {
					System.out.println("out of food, closing");
					this.resterant.executor.shutdownNow();
				}
				
				System.out.println("order up");
				synchronized (resterant.waitePerson) {
					resterant.meal = new Meal(count);
					resterant.waitePerson.notifyAll();
				}

				TimeUnit.MILLISECONDS.sleep(100);

			} catch(InterruptedException e) {
				//e.printStackTrace();
				System.out.println("chef interrupted");
			}
		}
	}

}
