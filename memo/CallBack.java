package memo;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.omg.CORBA.PUBLIC_MEMBER;

interface Incrementabel {
	void increment();
}

class Caller1 implements Incrementabel {
	private int i;
	public void increment() {
		System.out.println(this.i ++);
	}
}

class MyIncrementable {
	public void increment() {System.out.println("other option");}
	public static void f(MyIncrementable mi) {mi.increment();};
}

class Caller2 extends MyIncrementable {
	private int i = 0;
	public void increment() {
		super.increment();
		System.out.println(i ++);
	}
	
	private class Closure implements Incrementabel {

		@Override
		public void increment() {
			// TODO Auto-generated method stub
			Caller2.this.increment();
		}
	}
	public Closure getClosure() {
		return new Closure();
	}	
}

class Caller {
	private Incrementabel CallerReference;
	
	public Caller(Incrementabel callerReference) {
		this.CallerReference = callerReference;
	}
	
	public void go() {
		this.CallerReference.increment();
	}	
}

public class CallBack {
 public static void main(String[] args) {
	 Caller1 caller1 = new Caller1();
	 Caller2 caller2 = new Caller2();
	 
	 MyIncrementable.f(caller2);
	 Caller caller3 = new Caller(caller1);
	 Caller caller4 = new Caller(caller2.getClosure());
	 
	 caller3.go();
	 caller3.go();
	 caller4.go();
	 caller4.go();
 }
}
