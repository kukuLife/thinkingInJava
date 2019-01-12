package testString;

public class Hex {

	public static String changeTo16 (byte[] bytes) {
		int n = 0;
		for(byte b : bytes) {
			System.out.println(b);
		}
		
		return null;
	}
	
	private void hug() {
		System.out.println("hug");
	}
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException {
		Hex hex = new Hex();
		Class<? extends Hex> hex2 = hex.getClass();
		Hex hex3 = (Hex) hex2.newInstance();
		hex3.hug();
	}
	
}
