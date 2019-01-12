package memo;

interface DestinationWan {
	
}

public class Parcel10 {
	
	public DestinationWan destination(final String dest, final float price) {
		return new DestinationWan() {
			private int cost;
			{
				cost = Math.round(price);
				if(cost > 100) {
					System.out.println("Over budget");
				}
			}
			
			private String label = dest;
			public String readLable() {return this.label;};
		};
	}
	
	
}
