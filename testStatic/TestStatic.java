package testStatic;

public class TestStatic {
	public static void SM () {
		System.out.println("static method");
		//NSM();
	}
	
	public void NSM() {
		System.out.println("no static method");
		SM();
	}
	
}
