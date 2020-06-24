//use to open file
import java.io.File;
import java.io.FileInputStream;
//the exception type when file not found
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConvert{
	//list to store character and its corresponding morse code 
	private final ArrayList<MorseCode> listCodes;
	
	//non-default constructor 
	public MorseCodeConvert(String fileName){
		listCodes = new ArrayList<MorseCode>();
		//declare a Scanner class instance and initialize it as null
		Scanner file = null;
		
		try {
			file = new Scanner(new FileInputStream(new File(fileName)));
			//read all the lines from the file
			while(file.hasNext()) {
				//split method separates the line by a tab
				String[] line = file.nextLine().split("\t");
			    //check if the array s contains two elements:the character and its corresponding morse code
			    if(line.length == 2) {
			    	try {
			    		//convert the datatype of character from String to char
			    		char character = line[0].charAt(0);
			    		//create an instance of MorseCode class that contains the character and corresponding more code
			    		MorseCode obj = new MorseCode(character,line[1]);
			    		//add each valid line to array list
			    		listCodes.add(obj);
			    	}
			    	//When there is a invalid character, the MorseCode will throw an exception which catch by this block
			    	catch(Exception ex) {
			    		//print the error message
			    		System.err.println(ex.toString());
			    	}
			    }
			    //if there is only one entry in the line and the line is not empty 
			    else if(line[0].length() != 0) {
			    	//print out the invalid line
			    	System.out.println("Invalid line: " + line[0]);
			    }
			 } 
		  
		}
		//if the file not found, throw an exception which catch by this block
		catch(FileNotFoundException fe){
			 System.err.println("Failed to open file: " + fileName);
		}
		//finally block will run no matter whether there is an exception in try catch block or not
		finally{
			//close the file if not null
			if (file != null) {
				file.close();
			}
		}
	}
	
	//print the character and its corresponding morse code in the array list
	public void printEncodingList() {
		//iterate each element in the array list 
		for(MorseCode obj:listCodes) {
			System.out.println(obj.getCharacter() + "\t" + obj.getEncoding());
		}
	}
	
	//convert a random character to morse code
	private String convert(char character) {
		//if the character is space, return empty line
		if(character == ' ') {
			return "";
		}
		for(MorseCode obj:listCodes) {
			//check if the input can convert to the valid morse code 
			if(obj.getCharacter() == character) {
				//return the corresponding morse code
				return obj.getEncoding() + " ";
			}
		}
		//otherwise,return the question mark
		return "? ";
	}
	
	//convert a string to its corresponding morse code
	public void encodeString(String line) {
		//if the input is either null or an empty string,print next line
		if(line == "" || line == null) {
			System.out.println("");
		}
		else {
			for(int i = 0; i < line.length(); i++) {
				//convert the character to datatype char and upper case
				char character = Character.toUpperCase(line.charAt(i));
				//convert the character to its corresponding morse code
				String encoding = convert(character);
				System.out.print(encoding);
			}
			System.out.println("");
		}
	}
	
	//convert the contents of the file to morse code
	public void encodeFile(String fileName) throws Exception{
		Scanner file = null;
		
		try {
			file = new Scanner(new FileInputStream(new File(fileName)));
			while(file.hasNext()) {
				//use the encodeString method to convert each line of the file to morse code
				encodeString(file.nextLine());
			}
		}
		//if the file not found,throw an exception
		catch(FileNotFoundException fe) {
			throw new Exception("Failed to open file: " + fileName);
		}
		finally{
			if(file != null) {
				file.close();
			}
		}
	}
}	
	
	
	
	
	
	
	
	
	
	
	
