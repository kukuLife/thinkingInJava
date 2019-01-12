package Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import Reflection.DynamicProxyHandler.Bird;

public class DynamicProxyHandler {

	public interface Bird {
		public void shout();
	}
	
	public static void main(String[] args) {
		Bird original = new ABird();
		original.shout();
		
		Bird proxy = (Bird)Proxy.newProxyInstance(Bird.class.getClassLoader(), new Class[]{Bird.class}, new invocatoinalBird(original));
		proxy.shout();
	}
}






class ABird implements Bird{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("A Bird");
	}
	
}


class invocatoinalBird implements InvocationHandler{
	
	private Object proxied;
	
	public invocatoinalBird(Object original) {
		// TODO Auto-generated constructor stub
		this.proxied = original;
	}

	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before method is called");
		method.invoke(proxied, args);
		System.out.println("After called");
		return null;
	}
	
}

