package thinkingInJava.gardenCount;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GardenTest {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0;i < 10;i ++) {
			exec.execute(new Entrance(i));
		}
			TimeUnit.SECONDS.sleep(3);
			Entrance.Cancel();
			exec.shutdown();
			System.out.println("total: " + Entrance.getTotalCount());
			System.out.println("sumEntrance :" + Entrance.sumEntrance());
	
		
	
	}

}
