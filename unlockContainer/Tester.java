package unlockContainer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class Tester<C> {

	
	static int testReps = 10;
	static int testCycles = 1000;
	static int containerSize = 1000;
	abstract C ContainerInitiallizer();
	abstract void startReadersAndWriters();
	C testContainer;
	String testId;
	int nReaders;
	int nWriters;
	volatile long readResult = 0;
	volatile long readTime = 0;
	volatile long writeTime = 0;
	
	CountDownLatch enDownLatch;
	static ExecutorService exe = Executors.newCachedThreadPool();
	Integer[] writeData;
	
	Tester(String testId, int nReaders, int nWriters) {
		// TODO Auto-generated constructor stub
		this.testId = testId;
		this.nReaders = nReaders;
		this.nWriters = nWriters;
		
		writeData = new Integer[containerSize + 1];
		for(int i = 0; i < writeData.length; i ++) {
			writeData[i] = randomFill();
		}
	
		for(int i = 0;i < testReps; i ++) {
			runTest();
			readTime = 0;
			writeTime = 0;
		}
	}
	
	void runTest() {
		enDownLatch = new CountDownLatch(nReaders + nWriters);
		testContainer = ContainerInitiallizer();
		startReadersAndWriters();
		
		try{
			enDownLatch.await();
		}catch(InterruptedException e) {
			System.out.println("endLatch ended");
		}
		
		System.out.printf("%-27s %14d %14d\n", testId, readTime, writeTime);
		
		
		if(readTime != 0 && writeTime != 0) {
			System.out.printf("%-27s %14d\n","readTime + writeTime =", readTime + writeTime);
		}
	}
	
	private int randomFill() {
	   Random rand = new Random();
	    int randomNum = rand.nextInt();
	    return randomNum;
	}
	
	
	
	abstract class TaskTest implements Runnable {

		abstract void test();
		abstract void putResults();
		long duration;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			long startTime = System.nanoTime();
			this.test();
			duration = System.nanoTime() - startTime;
			
			synchronized (Tester.this) {
				putResults();
			}
			enDownLatch.countDown();
		}

	}
	
	
	public static void initMain(String[] args) {
		if(args.length > 0) {
			testReps = new Integer(args[0]);
			
		}
	
		if(args.length > 1) {
			testCycles = new Integer(args[1]);
			
		}
	
		if(args.length > 2) {
			containerSize = new Integer(args[2]);
		}
	
		System.out.printf("%-27s %14s %14s\n", "Type", "ReadTime", "WriteTime");
	
	
	}
	
	
}
