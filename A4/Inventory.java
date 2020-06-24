import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Inventory {
	private final ArrayList<Screen> listInventory;
	
	//default constructor
	public Inventory() {
		this.listInventory = new ArrayList<Screen>();
	}
	
	//return the size of arraylist
	public int inventoryCount() {
		return this.listInventory.size();
	}
	
	//append an Screen object into arraylist
	public boolean addToInventory(Screen sc) throws Exception {		
		//check if any duplicate Screen object
		if(this.listInventory.contains(sc)) {
			throw new Exception("The inventory contains a similar Screen object");
		}
		//add the item and return true
		this.listInventory.add(sc);
		return true;
	}
	
	//return the arraylist that contain ComputerMinitor object
	public ArrayList<ComputerMonitor> listComputerMonitor(){
		ArrayList<ComputerMonitor> result = new ArrayList<ComputerMonitor>();
		//iterate each element in the array
		for(Screen sc : this.listInventory) {
			//check if the element belong to computerMonitor class
			if(sc instanceof ComputerMonitor) {
				result.add((ComputerMonitor) sc);
			}
		}
		return result;
	}
	
	//return the arraylist that contain SmartTV object
	public ArrayList<SmartTV> listSmartTV(){
		ArrayList<SmartTV> result = new ArrayList<SmartTV>();
		for(Screen sc : this.listInventory) {
			if(sc instanceof SmartTV) {
				result.add((SmartTV) sc);
			}
		}
		return result;
	}
	
	//output the table
	public void printInventory() {
		String boarder = "+-------+-------------+-------------+------------+--------------+----------+-------+------------+";
		System.out.println(boarder);
		//print the label
		System.out.printf("|%5s  |%7s      |%9s    |%10s  |%13s |%6s    |%6s |%7s     |%n","Type","ID","Price","Make Date","Manufacturer","Model","Glass","OS");
		//create an SimpleDateFormat class instance to format the Date class
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		for(Screen sc : this.listInventory) {
			System.out.println(boarder);
			System.out.printf("| %-6s", sc.getType());
			System.out.printf("| %-12d", sc.getId());
			System.out.printf("| $%,-11.2f", sc.getSalePrice());
			//Convert the Date object into String
			String date = formatter.format(sc.getMakeDate());
			System.out.printf("| %-11s", date);
			System.out.printf("| %-13s", sc.getManufacturer());
			System.out.printf("|%9s ", sc.getModel());
			//check if the Screen object belong to CRT class
			if(sc instanceof CRT) {
				//print the glassthickness
				System.out.printf("|%6.2f ", ((CRT)sc).getGlassThickness());
			}
			else {
				System.out.printf("|%6s ", " ");
			}
			//check if the Screen object belong to SmartTV, if yes then print the operating system,else print empty line
			System.out.printf("|%11s ", sc instanceof SmartTV ? ((SmartTV) sc).getOperatingSystem() : " ");
			System.out.printf("|%n");
		}
		System.out.println(boarder);					
	}
}
