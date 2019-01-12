package abstractClass;

public abstract class TestAbstractClass {
	abstract void AbstrackMethod();
	
	public static void main(String[] args) {
		System.out.println("pirnt A method");
	}
}

class A extends TestAbstractClass {
	@Override
	void AbstrackMethod() {
		System.out.println("Abstract method A");
		
	}
	
}

