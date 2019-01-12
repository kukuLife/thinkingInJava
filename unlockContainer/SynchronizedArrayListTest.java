package unlockContainer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedArrayListTest extends listTest {
	
	SynchronizedArrayListTest(int nReaders, int nWriters) {
		super("synchronized arrayList", nReaders, nWriters);
		// TODO Auto-generated constructor stub
	}

	@Override
	List<Integer> ContainerInitiallizer() {
		return new ArrayList<Integer>(containerSize);
	}

}
