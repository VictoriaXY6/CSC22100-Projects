import java.util.Date;

public class SmartTV extends Screen {
	private String operatingSystem;

	//non-default constructor
	public SmartTV(String operatingSystem, long id, double salePrice, Date makeDate, String manufacturer, String model) {
		super(id, salePrice, makeDate, manufacturer, model);
		this.operatingSystem = operatingSystem;
	}

	//return the String "Smart"
	@Override
	public String getType() {
		return "Smart";
	}

	//getter and setter method
	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	//check if two SmartTV objects are equal
	@Override
	public boolean equals(Object obj) {
		//if the parameter doesn't belong to the SmartTV, then return false
		if(!(obj instanceof SmartTV)) {
			return false;
		}
		//downcasting, which convert the reference type from super class to sub class
		SmartTV tmp = (SmartTV) obj;
		//if the model number is equal, return true
		if(this.getModel().equals(tmp.getModel())) {
			return true;
		}
		return false;
	}
}
