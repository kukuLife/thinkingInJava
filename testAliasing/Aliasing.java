package testAliasing;

public class Aliasing {
	
	private int i = 0;
	
	private void f(Aliasing a) {
		a.i ++;
	}
	
	public static void main(String args[]) {
		int i = 0;
		Aliasing a = new Aliasing();
		a.f(a);
		
		System.out.println(a.i);
	}
	
}
