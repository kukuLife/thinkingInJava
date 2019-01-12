package testExtends;

import java.awt.print.Printable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestExtends{

	
	public static void main(String[] args) {
		String text = "--10252";
		Matcher m=Pattern.compile("(\\-)?[0-9]+").matcher(text);
		System.out.println(m.find());
	}
	
	
}



