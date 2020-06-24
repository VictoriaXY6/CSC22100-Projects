import java.util.Date;

public abstract class ComputerMonitor extends Screen {
	//non-default constructor
	public ComputerMonitor(long id, double salePrice, Date makeDate, String manufacturer, String model) {
		//called super class constructor
		super(id, salePrice, makeDate, manufacturer, model);
	}

	
}
