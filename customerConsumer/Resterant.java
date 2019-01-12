package customerConsumer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Resterant {
	
	Meal meal;
	Chef chef = new Chef(this);
	WaitePerson waitePerson = new WaitePerson(this);
	ExecutorService executor = Executors.newCachedThreadPool();
	
	public Resterant() {
		executor.execute(waitePerson);
		executor.execute(chef);
	} 
	
	public static void main(String[] args) {
		new Resterant();
	}
	

}
