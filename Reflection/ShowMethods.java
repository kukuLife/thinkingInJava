package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ShowMethods {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<String> sClass = (Class<String>) Class.forName("java.lang.String");
		Method[] methods = sClass.getMethods();
		Constructor[] constructors = sClass.getConstructors();
		
		for(Method method : methods) {
			System.out.println(method);
		}
		
		for(Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
	}
}
