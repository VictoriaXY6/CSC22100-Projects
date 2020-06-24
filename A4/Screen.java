import java.util.Date;

public abstract class Screen {
	private long id;
	private double salePrice;
	private Date makeDate;
	private String manufacturer;
	private String model;
	
	//non-default constructor
	public Screen(long id, double salePrice, Date makeDate, String manufacturer, String model) {
		this.id = id;
		this.salePrice = salePrice;
		this.makeDate = makeDate;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	//abstract method getType
	public abstract String getType();
	
	//getter and setter methods
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	//abstract method equals
	public abstract boolean equals(Object obj);

	//Override method, output the data of the object
	@Override
	public String toString() {
		return getType() + " " + getId();
	}
}
