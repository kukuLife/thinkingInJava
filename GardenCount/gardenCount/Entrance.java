package thinkingInJava.gardenCount;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.CancelablePrintJob;

public class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	
	private int number = 0;
	
	private final int id;
	
	private static volatile boolean canceled = false;
	
	public static void Cancel() {
		canceled = true;
	}
	
	
	public Entrance(int id) {
		this.id = id;
		entrances.add(this);
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!canceled) {
			synchronized (this) {
				number ++;
			}

			System.out.println(this + "Total :" + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		System.out.println("stopping" + this);
	}
	
	
	public static int getTotalCount() {
		return count.getValue();
	}
	
	public synchronized int getValue() {
		return number;
	}
	
	public String toString() {
		return "Entrance" + this.id + ":" + this.getValue();
	}
	
	public static int sumEntrance() {
		int sum = 0;
		for(Entrance entrance:entrances) {
			sum = sum + entrance.getValue();
		}
		return sum;
	}
	
	
	
	
	
}
