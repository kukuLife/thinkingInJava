package customerConsumer;

public class WaitePerson implements Runnable{

	Resterant resterant;
	
	public WaitePerson(Resterant r) {
		// TODO Auto-generated constructor stub
		resterant = r;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		
		while(!Thread.interrupted()) {

				
				synchronized (this) {
					if(resterant.meal == null) {				
						wait();
					}
				}
				
				System.out.println("waitPerson got meal" + resterant.meal);
				
				synchronized (resterant.chef) {
					resterant.meal = null;
					resterant.chef.notifyAll();
				}
					
		}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("waitPerson interrupted");
		}			
		
		
		
	}
	
}
