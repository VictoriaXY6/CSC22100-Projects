import java.util.Date;

public class CRT extends ComputerMonitor {
	private double glassThickness;
	
	//non-default constructor
	public CRT(double glassThickness, long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
		this.glassThickness = glassThickness;
	}

	//getter and setter method
	public double getGlassThickness() {
		return glassThickness;
	}
	
	public void setGlassThickness(double glassThickness) {
		this.glassThickness = glassThickness;
	}

	//return string of "CRT"
	@Override
	public String getType() {
		return "CRT";
	}

	//check if two CRT objects are equal
	@Override
	public boolean equals(Object obj) {
		//return false if the parameter doesn't belong to CRT
		if(!(obj instanceof CRT)) {
			return false;
		}
		//downcasting
		CRT tmp = (CRT) obj;
		//check if two objects have the same id
		if(tmp.getId() == this.getId()) {
			return true;
		}
		return false;
	}
	
}
