import java.util.Date;

public class LED extends ComputerMonitor {
	//non-default constructor
	public LED(long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
	}
	
	//check if two LED objects are equal
	@Override
	public boolean equals(Object obj) {
		//check if the parameter belongs to LED class
		if(!(obj instanceof LED)) {
			return false;
		}
		//downcasting
		LED tmp = (LED) obj;
		//check if the objects' sale prices are equal
		if(tmp.getSalePrice() == this.getSalePrice()) {
			return true;
		}
		return false;
	}
	
	//return the string of "LED"
	@Override
	public String getType() {
		return "LED";
	}
}
