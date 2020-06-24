package application;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

public class ListsOfCircle {
	//XmlElement specifics XML element name for each object in the ArrayList
	@XmlElement(name="Circle")
	//store list of circle data
	private ArrayList<A5Shape> listCircle = new ArrayList<A5Shape>();

	//return the array list<A5Shape>
	public ArrayList<A5Shape> getListCircle() {
		return listCircle;
	}	
}
