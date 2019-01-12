package testMultiCondition;

public class TestMultiCondition {
	int i = 0;
	
	
	public void show() {
		System.out.println(this.i);
	}
	
	
	public static void main(String args[]) {
		child c = new child();
		c.show();
	}
	
}

class child extends TestMultiCondition {
	int i = 1;
	
	public void show() {
		System.out.println(this.i);
	}
}
