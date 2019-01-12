package bankSimulator;

import java.util.concurrent.ArrayBlockingQueue;

public class test extends ArrayBlockingQueue<String> {
	public test(int capacity) {
		super(capacity);
	}

	public static void main(String args[]) throws InterruptedException {
		test test = new test(10);
		test.put("sss");
	}
}
