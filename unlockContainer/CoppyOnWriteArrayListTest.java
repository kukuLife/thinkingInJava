package unlockContainer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CoppyOnWriteArrayListTest extends listTest{

	CoppyOnWriteArrayListTest(int nReaders, int nWriters) {
		super("copy on write arrayList", nReaders, nWriters);
		// TODO Auto-generated constructor stub
	}

	@Override
	List<Integer> ContainerInitiallizer() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>(containerSize);
	}


}
