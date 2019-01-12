package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
	public static void main(String args[]) {
		List<Integer> integers = new ArrayList<Integer>();
		
		float s = 2;
		
		for(int i = 0; i < 12; i ++) {
			integers.add(i);
		}
		
		Iterator<Integer> it = integers.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
			
		}
		
		for(Integer tempI : integers) {
			tempI = tempI + 1;
		}
		
		
		it = integers.iterator();
		for(int i = 0; i < 6; i ++) {
			it.next();
			it.remove();
		}
		
		System.out.println(integers);
		
	}
}
