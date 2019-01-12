package unlockContainer;


import java.net.Inet4Address;
import java.util.List;

import javax.management.relation.Relation;
import javax.naming.spi.DirStateFactory.Result;

abstract class listTest extends Tester<List<Integer>> {

	listTest(String testId, int nReaders, int nWriters) {
		super(testId, nReaders, nWriters);
	}

	
	class Reader extends TaskTest {

		long result = 0;
		
		@Override
		void test() {
			// TODO Auto-generated method stub
			for(long i = 0;i < testCycles; i ++){
				for(int index = 0; index < containerSize; index ++) {
					result += result; 
				}
			}
			
		}

		
		@Override
		void putResults() {
			// TODO Auto-generated method stub
			readResult += result;
			readTime += duration;
		}
		
	}	
	
	
	class Writer extends TaskTest {		
		@Override
		void test() {
			// TODO Auto-generated method stub
			for(long i = 0; i < testCycles; i ++) {
				for(int index = 0; index < containerSize; index ++) {
					
					testContainer.set(index, writeData[index]);
				}
			}
			
		}

		@Override
		void putResults() {
			// TODO Auto-generated method stub
			writeTime += duration;
			
		}
	}
	
	
	void startReadersAndWriters() {
		for(int i = 0; i < nReaders; i ++) {
			exe.execute(new Reader());
		}
		
		for(int i = 0; i < nWriters; i ++) {
			exe.execute(new Writer());
		}
	
	
	}


	
	
}
