package polymorphic;

import java.awt.print.Printable;

public class ConstructorPolymorphic {
	
	ConstructorPolymorphic() {
		System.out.println("before ConstructorPolymorphic");
		draw();
		System.out.println("after ConstructorPolymorphic");
	}
	
	public void draw() {
		System.out.println("ConstructorPolymorphic");
	}
	
	public static void main(String[] args) {
		new DerivedConstructorPolymorphic();
	}
	
}

class DerivedConstructorPolymorphic extends ConstructorPolymorphic {
	private int i = 1;
	
	public DerivedConstructorPolymorphic() {
		// TODO Auto-generated constructor stub
		super.draw();
	}
	
	public void draw() {
		System.out.println("DerivedConstructorPolymorphic" + i);
	}
	
}

