package memo;

public class HEX {
	public static String format(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for(byte a : bytes) {
			if(n % 16 == 0) result.append(String.format("%05X", n));
				result.append(result.append(String.format("%02X", a)));
				n ++;
			if(n % 16 == 0) result.append("/n");
		}
		return result.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(format(new byte[]{1,2,3,4,5,6,7,7,8,9,0,2,1,1,2}));
	}
}
