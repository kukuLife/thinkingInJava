package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionArray {
	public static void main(String args[]) {
		
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 6 ));
		Collections.addAll(collection, 7, 8, 9, 10);
		System.out.println(collection);
		Integer[] integers = {11, 12};
		collection.addAll(Arrays.asList(integers));
		System.out.println(collection);
		Collections.addAll(collection, integers);
		List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
		
	}
}
