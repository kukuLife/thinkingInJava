package collection;

import java.util.Iterator;

public class TestIterator2 {
	public static void main(String[] args) {
		MyIterator myIterator = new MyIterator();
		for(String str : myIterator) {
			System.out.println(str);
		}
	}

}

class MyIterator implements Iterable<String> {
	
	protected String[] words = "time is fucking".split(" ");
	
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>() {
			private int index = 0;
			@Override
			public String next() {
				return words[index++];
			}
			
			@Override
			public boolean hasNext() {
				return (index < words.length);
			}
		};
	}

	
}

